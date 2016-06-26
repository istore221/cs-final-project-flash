
package cs.pkgfinal.project;

import cs.pkgfinal.project.lib.CandidateAssignment;
import cs.pkgfinal.project.lib.CandidateSolution;
import cs.pkgfinal.project.lib.PreferenceTable;
import cs.pkgfinal.project.lib.StudentEntry;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class CsFinalProject {

   
    public static void main(String[] args) {
        try {
           
            
            PreferenceTable prefs = new PreferenceTable("src/project_allocation_data.tsv");
           CandidateSolution cs = new CandidateSolution(prefs);
           System.out.println( "Energy -->"+ cs.getEnergy());
           System.out.println( "Fitness -->"+ cs.getFitness());
            
         
            
            
        } catch (FileNotFoundException ex) {
            
          System.out.println(ex.getMessage());
            
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
    }
}
