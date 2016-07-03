
package cs.pkgfinal.project.lib;

//mapping from a single student to a single project.(we are trying to avoid assigning project which has already preassigned as much as possible)

import java.util.Random;

public class CandidateAssignment {
    
    private StudentEntry student;
    private String project = null;
    private String previousProject = null;
   
    
    public CandidateAssignment(){
        
    }
    
     public CandidateAssignment(StudentEntry student){
        // constructor initizlize the student and also randomly assign a project
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
        
        // randomly assign a project  also track the changes of assignment using previousProject member variable
             
       String randomPref = this.student.getRandomPreference();
       this.previousProject = this.project;
       this.project = randomPref;
           
    }

    public void  undoChange(){
        
        // undo the assignemt
        
        this.project = this.previousProject;
        this.previousProject = null;
    }

  
    public int getEnergy(){
       
      // get the ranking (how prefered this project by the student) based on below formula
        
      int rank = this.student.getRanking(this.project);
       
      return (rank+1)*(rank+1);
       
    }
  
   
    public int getDisappointment(){
        return student.getOrderedPreferences().indexOf(this.project);
    }
   
   

   
   
}
