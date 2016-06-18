
package cs.pkgfinal.project.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class PreferenceTable {
        
  
    private Vector table;
    private Hashtable<String, StudentEntry> studentLookup;
  
    
    public PreferenceTable(){
        
       this.table = new Vector();
       this.studentLookup = new Hashtable<String, StudentEntry>();
       
    }
    
    public PreferenceTable(String filePath) throws FileNotFoundException, IOException{
         
        this();
        this.loadContentFromFile(filePath);
        
    }
    
    
    private void loadContentFromFile(String filePath) throws FileNotFoundException, IOException{
        
     
      BufferedReader br  = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));;
        String  row = null;
        int rowNo = 0;
        Vector vector = new Vector();
        
        while ((row = br.readLine()) != null) {
           
            if(rowNo != 0){
               
                 StringTokenizer tokens = new StringTokenizer(row, "\t");
                    Vector<String> rowVector =  new Vector<String>();

                    while (tokens.hasMoreTokens()) {

                        String token = tokens.nextToken();
                        rowVector.addElement(token);


                    }
                    vector.addElement(rowVector);
            }
           
         
            
            rowNo++;
            
             
         }
        
        this.table = vector;
        
       
        /* ----------------------Hash table conversion------------------------------ */
        
       
    
        Enumeration en = this.table.elements();
        
         while(en.hasMoreElements()){

           Vector<String> rowTemp =  (Vector<String>) en.nextElement();
           StudentEntry student = new StudentEntry(rowTemp.get(0));
           
            if(rowTemp.get(1).equalsIgnoreCase("yes")) {
                
                student.setHasPreassignedProject(true);
            }
            else{
                
                 student.setHasPreassignedProject(false);
            }
            
             Enumeration enProjects = rowTemp.elements();
             int index = 0;
              Vector<String> studentProjects = new Vector<>();
              
             while(enProjects.hasMoreElements()){
                 
                 if(index >= 2){
                       
                     studentProjects.addElement((String) enProjects.nextElement());
                     
                 }
                 else{
                    
                     enProjects.nextElement();
                 }
                 index++;
                
              
                
                  
             }
             
              student.setOrderedPreferences(studentProjects);
              this.studentLookup.put(student.getStudentName(), student);
            
           
       
             
        }
         
       
                        
    }
    
    public void printVector(){
            
      Enumeration en = this.table.elements();
      
      while(en.hasMoreElements()){
          
          System.out.print(en.nextElement() + "\n");
      }
         
        
    }
    
    public Vector<StudentEntry> getAllStudentEntries(){
           
        Vector<StudentEntry> studentEntities = new Vector<StudentEntry>();
         
       for(String key : this.studentLookup.keySet()) {
         
            studentEntities.addElement(this.studentLookup.get(key));
	}
        
        return studentEntities;
    }
    
    
    public StudentEntry getEntryFor(String sname){
          
       
        try {
            return this.studentLookup.get(sname);
    	} catch (NullPointerException e) {
    		return null;
    	}
        
       
    }
    
    
    
    
    
    public StudentEntry getRandomStudent(){
        
        Vector<StudentEntry> studentEntities = this.getAllStudentEntries();
        
       Random random = new Random();
       int randomNumber = random.nextInt(((studentEntities.size()-1) - 0) + 1) + 0; // 0 to vector length
              
        return studentEntities.get(randomNumber);
    }
    
    public String getRandomPreference(){
        
        StudentEntry randomStudentEntry = this.getRandomStudent();
        
        return randomStudentEntry.getRandomPreference();
           
    }
    
    public void fillPreferencesOfAll(int maxPrefs){
        
        Vector<StudentEntry> studentEntities = this.getAllStudentEntries();
        
          Enumeration en = studentEntities.elements();
        
          while(en.hasMoreElements()){ 
          
              StudentEntry student = (StudentEntry) en.nextElement();
             
              if(!(student.hasPreassignedProject() || student.getOrderedPreferences().size() == 10) ){
                 
                    while(!(student.getOrderedPreferences().size()==maxPrefs)){
                        
                        String newPreference = this.getRandomPreference();
                        
                        if(!student.hasPreference(newPreference)){
                            
                            student.addProject(newPreference);
                        }
                        
                        
                        
                    }
                    
                     
                 
              }
              
             
             
             
              
          }
        
        
    }
            
            
    
}
