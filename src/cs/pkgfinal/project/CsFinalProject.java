
package cs.pkgfinal.project;

import cs.pkgfinal.project.lib.CandidateAssignment;
import cs.pkgfinal.project.lib.CandidateSolution;
import cs.pkgfinal.project.lib.PreferenceTable;
import cs.pkgfinal.project.lib.SimulatedAnnealing;
import cs.pkgfinal.project.lib.StudentEntry;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class CsFinalProject {

   
    public static void main(String[] args) {
        try {
           
            
            PreferenceTable prefs = new PreferenceTable("src/project_allocation_data.tsv");
            SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(prefs,10000L);
            CandidateSolution solution =  simulatedAnnealing.anneal();
            System.out.println(solution.getEnergy());
//            
//           CandidateSolution cs1 = new CandidateSolution(prefs);
//            CandidateSolution cs2 = new CandidateSolution(prefs);
//           
//           System.out.println("candidateSolution1 energy -->"+cs1.getEnergy());
//        System.out.println("candidateSolution1 fitness -->"+cs1.getFitness());
//            
//            System.out.println("candidateSolution2 energy -->"+cs2.getEnergy());
//        System.out.println("candidateSolution2 fitness -->"+cs2.getFitness());
//            
            
            
        } catch (FileNotFoundException ex) {
            
          System.out.println(ex.getMessage());
            
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
    }
}
