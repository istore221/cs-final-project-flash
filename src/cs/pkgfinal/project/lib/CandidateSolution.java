
package cs.pkgfinal.project.lib;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

/*
 each instance of CandidateSolution represents one possible solution to the project mapping task
    This class will later used for both our Simulated Annealing and Gene-c
    Algorithm solutions
*/
public class CandidateSolution {
    
    private Vector<CandidateAssignment> candidateAssignments;
  
    public CandidateSolution(){
        
        this.candidateAssignments = new Vector<CandidateAssignment>();
        
    }
    
      public CandidateSolution(PreferenceTable preferenceTable){
        
        this();
        
        preferenceTable.fillPreferencesOfAll(10);
        Vector<StudentEntry> studentEntities =  preferenceTable.getAllStudentEntries();
        Enumeration en = studentEntities.elements();
        
          while(en.hasMoreElements()){
              
              StudentEntry student = (StudentEntry) en.nextElement();
              candidateAssignments.add(new CandidateAssignment(student));
              
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
      
    
}
