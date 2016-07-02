
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
public class CandidateSolution implements Comparable<CandidateSolution>{
    
     private PreferenceTable preferenceTable;
    private Vector<CandidateAssignment> candidateAssignments;
    private Hashtable<String, Integer> duplicateAssignedProjects;
    private final int energyPenalty = 10 ;
   
  
    public CandidateSolution(){
        
        this.candidateAssignments = new Vector<CandidateAssignment>();
        this.duplicateAssignedProjects = new Hashtable<String, Integer>();
        
    }
    
      public CandidateSolution(PreferenceTable preferenceTable){
        
          // create random assignments for each student and put it on the list also try to avoid assigning projects which are already preassigned
          
        this();
        this.preferenceTable = preferenceTable;
        this.preferenceTable.fillPreferencesOfAll(10); // fill preferences of non preassigned students
      
          this.mapStudents();
          
          this.purifyAssignments(); // check assignments are already preassigned and if it is recursively assign non preassigned project
          
          
          this.putRepeatedOnHash();
           
          
          
        
       }
      
       public PreferenceTable getPreferenceTable() {
        return preferenceTable;
    }

   
    public void setPreferenceTable(PreferenceTable preferenceTable) {
        this.preferenceTable = preferenceTable;
    }

      
     public void mapStudents(){
         
        Vector<StudentEntry> studentEntities =  this.getPreferenceTable().getAllStudentEntries();
        Enumeration en = studentEntities.elements();
        
          while(en.hasMoreElements()){
              
              StudentEntry student = (StudentEntry) en.nextElement();
           
            
            
             CandidateAssignment assignment =  new CandidateAssignment(student);
             
              candidateAssignments.add(assignment);
            
            
            
          }
         
         
         
     }
      
     public void putRepeatedOnHash(){
         
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
          
          // try to avoid assigning preassigned projects Randomizly
                  
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
          // check if the given project has preassigned
          
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
        // return the assignemt for given name
        
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
       
        // return the occurence of the project on current solution list
        
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
        // return the panalties by refering duplicatehashtable and increment by panelty value for every repeat
         
         /*
          * Every time there is a collision i.e., two students are assigned the same project, add 1000 for the penalty. So if there are two collisions 2000, three collisions 3000 etc.
          */
       
          int penalties = 0;
          
          for (String key : this.duplicateAssignedProjects.keySet()){
              
              // why -1 because in my hash table occurences(value) = 2 means project X has two occurences on candidateAssignment list (two students share project X) so (2-1) * 1000 = 1000 
              penalties+= (this.duplicateAssignedProjects.get(key)-1) * this.energyPenalty;
              
          }
         
        
          
        
        return penalties;
    }
      
    public int getEnergy(){
        //higher the energy then the lower the fitness of a solution. 
         Enumeration en = this.candidateAssignments.elements();
         int energySum = 0; // sum of the energy of each of its candidate assignments
         
          
          while(en.hasMoreElements()){ 
              
              CandidateAssignment ca = (CandidateAssignment) en.nextElement();
              
               energySum+=ca.getEnergy();
              
              
          }
          
        
          
          return energySum+this.getPenalties();
        
    }
    
   
   
    
    
    public int getFitness(){
        //higher the fitness then the lower the energy of a solution.
        // measures how good the solution  is ( want something that gives low values for bad data and high values for good data)
        //something used in Genetic Algorithm. It is used in each iteration of the algorithm to evaluate the quality of all the proposed solutions to your problem in the current population. 
        
       return this.getEnergy() * -1;
       
        
        
    }
    
    
    public boolean isValid(){
        
        // if student get only one project from their expreessed preferences while the same project has not assigned other students its valid
        
         return !(this.duplicateAssignedProjects.size() > 0);
        
    }

    @Override
    public int compareTo(CandidateSolution o) {
       
          if(this.getFitness() == o.getFitness())
                         return 0;
                    return this.getFitness() > o.getFitness() ? -1 : 1;
    }

   
   

   
    
}
