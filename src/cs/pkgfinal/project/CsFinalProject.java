
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
           
            
            CandidateSolution sol = new CandidateSolution(prefs);
           
            //CandidateAssignment cand =  sol.getAssignmentFor("John Constantine");
            
            
            CandidateAssignment rand = sol.getRandomAssignment();
          
            rand.randomizeAssignment();
            
            System.out.println(rand.getStudent().getStudentName()+"--->"+rand.getProject());
            
            rand.undoChange();
            
             System.out.println(rand.getStudent().getStudentName()+"--->"+rand.getProject());
            
           
            
        } catch (FileNotFoundException ex) {
            
          System.out.println(ex.getMessage());
            
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
    }
}
