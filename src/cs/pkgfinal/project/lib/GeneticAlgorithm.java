
package cs.pkgfinal.project.lib;

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
    
     private int population = 0;
     
     
     public GeneticAlgorithm(){
         
         
     }
     
     public GeneticAlgorithm(int population){
         
            this.population = population;
         
     }

    
    public int getPopulation() {
        return population;
    }

  
    public void setPopulation(int population) {
        this.population = population;
    }

    
     
}
