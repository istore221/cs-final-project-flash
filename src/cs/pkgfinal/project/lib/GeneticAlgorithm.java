
package cs.pkgfinal.project.lib;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
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

    
    public CandidateSolution populate(){
            
          for(int i=0;i<this.initialPopulation;i++){
              
              CandidateSolution candidateSolution = new CandidateSolution(this.preferenceTable);
             
               newPopulation.add(candidateSolution);
               
          }
          
         
          
         for(int g=0;g<this.generations;g++){
           
                     // genarations loop
          
         Collections.sort(newPopulation); // sort by fitness best fitness to worst fitness
         
         if ((this.newPopulation.size() & 1) != 0) {
                
             // odd number of parents so remove the parent with smallerst fitness value
             this.newPopulation.remove( this.newPopulation.size() - 1);
         }
         
        
         int crossOverPoint = (newPopulation.get(0).getCandidateAssignments().size() / (new Random().nextInt((newPopulation.get(0).getCandidateAssignments().size() / 2) - 2 + 1) + 2)); // genarate a random crossover point between 2 to size/2
     
         int end = 0;
         
         
          List<CandidateSolution> tempNewPopulation = new ArrayList<CandidateSolution>(); // genaration holder
      
      
         for(int i=0;i<this.newPopulation.size() / 2;i++){
             
             int parentA  = end;
             int parentB = end+1;
             
             CandidateSolution c1 =  newPopulation.get(parentA);
             CandidateSolution c2 = newPopulation.get(parentB);
         
          
             
         /* C1 crossover  C2 */
         CandidateSolution newC1 = new CandidateSolution();
         
           for (CandidateAssignment assignment: c1.getCandidateAssignments().subList(0, crossOverPoint)) {
               
               newC1.getCandidateAssignments().add(assignment);
               
               
           }
            for (CandidateAssignment assignment: c2.getCandidateAssignments().subList(crossOverPoint, c1.getCandidateAssignments().size())) {
               
               newC1.getCandidateAssignments().add(assignment);
               
               
           }
           
            newC1.putRepeatedOnHash();
          
            /* C1 crossover  C2 */
           
             
            
         /* C2 Crossover C1 */
         CandidateSolution newC2 = new CandidateSolution();
         
           for (CandidateAssignment assignment: c1.getCandidateAssignments().subList(crossOverPoint, c1.getCandidateAssignments().size())) {
               
               newC2.getCandidateAssignments().add(assignment);
               
               
           }
            for (CandidateAssignment assignment: c2.getCandidateAssignments().subList(0, crossOverPoint)) {
               
               newC2.getCandidateAssignments().add(assignment);
               
               
           }
           
            newC2.putRepeatedOnHash();
            
             /* C2 Crossover C1 */
            
            /* if goal achieve return it */
            if(c1.getFitness() == 0){
                
                return c1;
            }
            if(c2.getFitness() == 0){
                
                return c2;
            }
            if(newC1.getFitness() == 0){
                
                return newC1;
            }
            if(newC2.getFitness() == 0){
                
                return newC2;
            }
              /* if goal achieve return it */
          
          
            
            

            
            //only replace parent if child is better  (survival of child)
            if(c1.getFitness() > newC1.getFitness()){
                
                 tempNewPopulation.add(c1);
                 
            }else{
                
                  tempNewPopulation.add(newC1);
                
            }
            if(c2.getFitness() > newC2.getFitness()){
                
                 tempNewPopulation.add(c2);
            }else{
                
                  tempNewPopulation.add(newC2);
            }
             //only replace parent if child is better (survival of child)
            
          
          
            
                   
             end = (parentB)+1;
             
             
             
         }
       
         
         this.newPopulation.clear();
         this.newPopulation = tempNewPopulation; // set current genaration to newPopulation
         
        
         
      
         }
         
         
      
           
        return this.newPopulation.get(0); // return the best solution with maximum fitness
    }

  

    
     
}
