
package cs.pkgfinal.project.lib;

//mapping from a single student to a single project.

import java.util.Random;

public class CandidateAssignment {
    
    private StudentEntry student;
    private String project = null;
    private String previousProject = null;
   
    
    public CandidateAssignment(){
        
    }
    
     public CandidateAssignment(StudentEntry student){
        
        this.student = student;
        this.randomizeAssignment();
    }
    
    
   
    public StudentEntry getStudent() {
        return student;
    }

  
    public void setStudent(StudentEntry student) {
        this.student = student;
    }

  
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
    
    
    public String getPreviousProject() {
        return previousProject;
    }

   
    public void setPreviousProject(String previousProject) {
        this.previousProject = previousProject;
    }
    
    
    public void randomizeAssignment(){
     
             
       String randomPref = this.student.getRandomPreference();
       this.previousProject = this.project;
       this.project = randomPref;
           
    }

    public void  undoChange(){
        
        
        this.project = this.previousProject;
        this.previousProject = null;
    }

  
    public int getEnergy(){
        
      int rank = this.student.getRanking(this.project);
       
      return (rank+1)*(rank+1);
       
    }
  
   

   
   

   
   
}
