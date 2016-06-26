
package cs.pkgfinal.project.lib;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/*
 each instance of CandidateSolution represents one possible solution to the project mapping task
    This class will later used for both our Simulated Annealing and Gene-c
    Algorithm solutions
*/
public class CandidateSolution {
    
    private Vector<CandidateAssignment> candidateAssignments;
    private Hashtable<String, Integer> duplicateAssignedProjects;
    private final int energyPenalty = 1000 ;
  
  
    public CandidateSolution(){
        
        this.candidateAssignments = new Vector<CandidateAssignment>();
        this.duplicateAssignedProjects = new Hashtable<String, Integer>();
        
    }
    
      public CandidateSolution(PreferenceTable preferenceTable){
        
        this();
        
        preferenceTable.fillPreferencesOfAll(10); // fill preferences of non preassigned students
        Vector<StudentEntry> studentEntities =  preferenceTable.getAllStudentEntries();
        Enumeration en = studentEntities.elements();
        
          while(en.hasMoreElements()){
              
              StudentEntry student = (StudentEntry) en.nextElement();
             
            
             CandidateAssignment assignment =  new CandidateAssignment(student);
             
              candidateAssignments.add(assignment);
            
            
            
          }
          
          this.purifyAssignments(); // check assignments are already preassigned and if it is recursively assign non preassigned project
          
          
          // put repeated projects on hashtable
          
           Enumeration enca = this.candidateAssignments.elements();
          
           while(enca.hasMoreElements()){
                 
                 CandidateAssignment assignment = (CandidateAssignment) enca.nextElement();
                 
               
                 
                 int occurrence = this.getAssignedProject(assignment);
                
                  if(occurrence > 1){
                        // put duplicates on hashTable
                      
                        this.duplicateAssignedProjects.put(assignment.getProject().intern(), occurrence);
                       
                    }
                  
                  
            }
           
          
          
          
        
       }

      
      private void purifyAssignments(){
          
                  
           Enumeration enca = this.candidateAssignments.elements();
         
           while(enca.hasMoreElements()){
               
              CandidateAssignment assignment = (CandidateAssignment) enca.nextElement();
              
              if(!assignment.getStudent().hasPreassignedProject()){
                   
                  while(this.hasAlreadyPreAssigned(assignment.getProject())){
                      
                      // loop while non preassigned project assigned to  object
                       assignment.randomizeAssignment();
                      
                  }
                 
                  
              }
             
              
               
           }
              
          
          
      }
      
      
      private boolean hasAlreadyPreAssigned(String project){
         
           Enumeration enca = this.candidateAssignments.elements();
         
           while(enca.hasMoreElements()){
               
                 CandidateAssignment assignment = (CandidateAssignment) enca.nextElement();
                 
                 if(assignment.getStudent().hasPreassignedProject() && assignment.getProject().equalsIgnoreCase(project)){
                    
                     return true;
                     
                 }
           }
          return false;
      }
      
      
      
    
    public Vector<CandidateAssignment> getCandidateAssignments() {
        return candidateAssignments;
    }

    
    public void setCandidateAssignments(Vector<CandidateAssignment> candidateAssignments) {
        this.candidateAssignments = candidateAssignments;
    }

   
  
      
    public CandidateAssignment getAssignmentFor(String sname){
        
          Enumeration en = this.candidateAssignments.elements();
        
          while(en.hasMoreElements()){ 
              
              CandidateAssignment ca = (CandidateAssignment) en.nextElement();
              if(ca.getStudent().getStudentName().equalsIgnoreCase(sname)){
                  
                  return ca;
              }
              
          }
        return null;
        
    }
    
    public CandidateAssignment getRandomAssignment(){
        
         Random random = new Random();
         int randomNumber = random.nextInt(((this.candidateAssignments.size()-1) - 0) + 1) + 0; // 0 to vector length
       
         return this.candidateAssignments.get(randomNumber);
        
    }
    
    
    public int getAssignedProject(CandidateAssignment assignment){
       
        
        Enumeration en = this.candidateAssignments.elements();
        int occurrence = 0;
        while(en.hasMoreElements()){ 
             
             CandidateAssignment ca = (CandidateAssignment) en.nextElement();
             if(ca.getProject().equalsIgnoreCase(assignment.getProject())){
                 
                 occurrence++;
             }
        }
        
        
       
        
        
        
        return occurrence;
    }
    
    
   
     public int getPenalties(){
        
         Enumeration en = this.candidateAssignments.elements();
          int penalties = 0;
          
           while(en.hasMoreElements()){ 
               
                 CandidateAssignment ca = (CandidateAssignment) en.nextElement();
                 
                 if(this.duplicateAssignedProjects.get(ca.getProject()) != null){
                   // assinged more than once
                    penalties+=this.energyPenalty;
               }
                 
           }
          
          
        return penalties;
    }
      
    public int getEnergy(){
        //higher the energy then the lower the fitness of a solution. (E + P)
         Enumeration en = this.candidateAssignments.elements();
         int energySum = 0; // sum of the energy of each of its candidate assignments
         
          
          while(en.hasMoreElements()){ 
              
              CandidateAssignment ca = (CandidateAssignment) en.nextElement();
              
               energySum+=ca.getEnergy();
              
              
          }
          
          
          return energySum+this.getPenalties();
        
    }
    
   
   
    
    
    public int getFitness(){
        //higher the fitness then the lower the energy of a solution. inverse of (E + P)  --->  (P - E)
      
       int penalties = this.getPenalties();
       int energy = this.getEnergy()-penalties;
     
       return penalties - energy;
       
        
        
    }
    
}
