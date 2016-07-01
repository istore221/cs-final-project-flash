
package cs.pkgfinal.project.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/*http://www.theprojectspot.com/tutorial-post/creating-a-genetic-algorithm-for-beginners/3
 * http://geneticalgorithms.ai-depot.com/Tutorial/Overview.html
 * GeneticAlgorithm genarate the search space (colection of CandidateSolutions) to get the most disired solution based on the fitness function of CandidateSolution object
 * 1) Fill the search space based on the number of generations given ex: if population == 50 genarate 50 CandidateSolution objects as search space
 * 2)  Each CandidateSolution of the population is then evaluated and we get the fitnesss via getFitnesss() method 
 * 3)[New population] Create a new population by repeating following steps until the new population is complete 
 * 3.1)  [Selection] Select two parent CandidateSolutions from a population according to their fitness (the better fitness, the bigger chance to be selected) 
 * 3.2) [Crossover] With a crossover probability cross over the parents to form a new offspring (children). If no crossover was performed, offspring is an exact copy of parents. 
 * 3.3) [Mutation] With a mutation probability mutate new offspring at each locus (position in CandidateSolution). 
 * 3.4) [Accepting] Place new offspring in a new population 
 * 4) [Replace] Use new generated population for a further run of algorithm 
 * 5)[Test] If the end condition is satisfied, stop, and return the best solution in current population 
 * 6)  [Loop] Go to step 2 
 */

public class GeneticAlgorithm {
    
     private long initialPopulation = 0; 
     private long generations = 0;
     private PreferenceTable preferenceTable;
     private List<CandidateSolution> newPopulation;
             
     public GeneticAlgorithm(){
         
         
     }
     
     public GeneticAlgorithm(PreferenceTable preferenceTable,long InitialPopulation,long generations){
            this();
            this.initialPopulation = InitialPopulation;
            this.preferenceTable = preferenceTable;
            this.newPopulation = new ArrayList<CandidateSolution>();
            this.generations = generations;
            
            
     }

  
    public long getInitialPopulation() {
        return initialPopulation;
    }

   
    public void setInitialPopulation(long initialPopulation) {
        this.initialPopulation = initialPopulation;
    }

    
    public PreferenceTable getPreferenceTable() {
        return preferenceTable;
    }

   
    public void setPreferenceTable(PreferenceTable preferenceTable) {
        this.preferenceTable = preferenceTable;
    }

    
    public CandidateSolution populate(int noOfPrefs){
            
          for(int i=0;i<this.initialPopulation;i++){
              
              CandidateSolution candidateSolution = new CandidateSolution(this.preferenceTable, noOfPrefs);
             
               newPopulation.add(candidateSolution);
               
          }
          
         Collections.sort(newPopulation); // sort by fitness best fitness to worst fitness
         
         if ((this.initialPopulation & 1) != 0) {
                
             // odd number of parents so remove the parent with smallerst fitness value
             this.newPopulation.remove( this.newPopulation.size() - 1);
         }
         
         
       
         
         CandidateSolution c1 =  newPopulation.get(0);
         CandidateSolution c2 = newPopulation.get(1);
          
         int crossOverPoint = c1.getCandidateAssignments().size() / 2;
         
        
         
         /* C1 Fucks C2 */
         CandidateSolution newC1 = new CandidateSolution();
         
           for (CandidateAssignment assignment: c1.getCandidateAssignments().subList(0, crossOverPoint)) {
               
               newC1.getCandidateAssignments().add(assignment);
               
               
           }
            for (CandidateAssignment assignment: c2.getCandidateAssignments().subList(crossOverPoint, 51)) {
               
               newC1.getCandidateAssignments().add(assignment);
               
               
           }
           
            newC1.putRepeatedOnHash();
          
            /* C1 Fucks C2 */
            
            
            
            /* C2 Fucks C1 */
         CandidateSolution newC2 = new CandidateSolution();
         
           for (CandidateAssignment assignment: c1.getCandidateAssignments().subList(crossOverPoint, 51)) {
               
               newC2.getCandidateAssignments().add(assignment);
               
               
           }
            for (CandidateAssignment assignment: c2.getCandidateAssignments().subList(0, crossOverPoint)) {
               
               newC2.getCandidateAssignments().add(assignment);
               
               
           }
           
            newC2.putRepeatedOnHash();
          
            /* C2 Fucks C1 */
            
           
         
 
         
        return null;
    }

  

    
     
}
