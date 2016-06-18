
package cs.pkgfinal.project.lib;

import java.util.Enumeration;
import java.util.Random;
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
        this.orderedPreferences.addElement(pname);
        this.preassigned = true;
       
    }
    
   
    public void addProject(String pname){
        
        if(!this.hasPreference(pname)){
            
             this.orderedPreferences.addElement(pname.intern());
             
        }
       
        
        
    }
    
    
    public String getRandomPreference(){
        
           Random random = new Random();
           int randomNumber = random.nextInt(((this.getOrderedPreferences().size()-1) - 0) + 1) + 0; // 0 to vector length
        
            return this.getOrderedPreferences().get(randomNumber);
    }
    
    
    public boolean hasPreference(String preference){
        
         Vector<String> prefs =  this.getOrderedPreferences();
         Enumeration en = prefs.elements();
        
          while(en.hasMoreElements()){
          
              String pref= (String) en.nextElement();
              
               if(pref.equalsIgnoreCase(preference)){
                   
                  return true;
               }
            }
         
         return false;
        
    }
    
   
}
