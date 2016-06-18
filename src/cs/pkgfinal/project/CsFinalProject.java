
package cs.pkgfinal.project;

import cs.pkgfinal.project.lib.PreferenceTable;
import cs.pkgfinal.project.lib.StudentEntry;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class CsFinalProject {

   
    public static void main(String[] args) {
        try {
           
            
            PreferenceTable preferenceTable = new PreferenceTable("src/project_allocation_data.tsv");
            preferenceTable.printVector();
          
            
            
        } catch (FileNotFoundException ex) {
            
          ex.printStackTrace();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
