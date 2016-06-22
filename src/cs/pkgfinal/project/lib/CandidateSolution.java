
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
        
        preferenceTable.fillPreferencesOfAll(10);
        Vector<StudentEntry> studentEntities =  preferenceTable.getAllStudentEntries();
        Enumeration en = studentEntities.elements();
        
          while(en.hasMoreElements()){
              
              StudentEntry student = (StudentEntry) en.nextElement();
             CandidateAssignment assignment =  new CandidateAssignment(student);
              candidateAssignments.add(assignment);
              
          }
          
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
    
    
     
      
    public int getEnergy(){
        
         Enumeration en = this.candidateAssignments.elements();
         int energySum = 0; // sum of the energy of each of its candidate assignments
          int penalties = 0;
          
          while(en.hasMoreElements()){ 
              
              CandidateAssignment ca = (CandidateAssignment) en.nextElement();
              
               energySum+=ca.getEnergy();
              
               if(this.duplicateAssignedProjects.get(ca.getProject()) != null){
                   // assinged more than once
                    penalties+=this.energyPenalty;
               }
          }
          
         
          
        
          
          return energySum+penalties;
        
    }
    
    
    public int getFitness(){
        
        throw new NotImplementedException();
        
    }
    
}
