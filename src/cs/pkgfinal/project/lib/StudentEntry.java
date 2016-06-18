
package cs.pkgfinal.project.lib;

import java.util.Vector;


public class StudentEntry {
    
    private String name;
    private boolean preassigned;
    private Vector<String> orderedPreferences; // orderBy most prefered to least prefered
    private int numberOfStatedPreferences;
    
    public StudentEntry(){
        
       
        this.orderedPreferences = new Vector<String>();
        
    }
    
    public StudentEntry(String name){
        
        this();
        this.name = name;
        
    }

    public String getStudentName() {
        return this.name;
    }

   
    public void setStudentName(String name) {
        this.name = name;
    }

   
    public boolean hasPreassignedProject() {
        
      return this.preassigned;
      
    }

    
    public void setHasPreassignedProject(boolean preassigned) {
        this.preassigned = preassigned;
        
    }

    public Vector<String> getOrderedPreferences(){
        
        return this.orderedPreferences;
    }
    
    public void setOrderedPreferences(Vector<String> vector) {
            
        this.orderedPreferences = vector;
        this.numberOfStatedPreferences = vector.size();
		
   }
    
   public int getNumberOfStatedPreferences(){
       
       return  this.numberOfStatedPreferences;
   }
  
   
    public void preassignProject(String pname){
        
        this.orderedPreferences.clear();
        this.orderedPreferences.add(pname);
        this.preassigned = true;
       
    }
    
   
    public void addProject(String pname){
        
        this.orderedPreferences.add(pname);
        
        
    }
    
    @Override
    public String toString() {
	return "Name: "+this.name+" prefereces: "+this.getOrderedPreferences();
    }
}
