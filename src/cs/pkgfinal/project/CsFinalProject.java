
package cs.pkgfinal.project;

import cs.pkgfinal.project.lib.CandidateAssignment;
import cs.pkgfinal.project.lib.CandidateSolution;
import cs.pkgfinal.project.lib.GeneticAlgorithm;
import cs.pkgfinal.project.lib.PreferenceTable;
import cs.pkgfinal.project.lib.SimulatedAnnealing;
import cs.pkgfinal.project.lib.StudentEntry;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;


public class CsFinalProject {

   
    public static void main(String[] args) {
        try {
           
            
           PreferenceTable prefs = new PreferenceTable("src/project_allocation_data.tsv");
//           SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(prefs,90000L);
//           CandidateSolution solution =  simulatedAnnealing.anneal();
//           System.out.println(solution.getEnergy());
           
          
         
            GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(prefs,15L,18);
            CandidateSolution  solution = geneticAlgorithm.populate();
            System.out.println(solution.getFitness());
            
           
            
            
            
            
        } catch (FileNotFoundException ex) {
            
          System.out.println(ex.getMessage());
            
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
    }
}
