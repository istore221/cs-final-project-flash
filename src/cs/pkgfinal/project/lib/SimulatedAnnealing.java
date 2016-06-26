
package cs.pkgfinal.project.lib;



import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/*

SimulatedAnnealing class resposnible for genarating and compiring randmdom solution objects up to given iteration value ex : iterations = 10 algortham repeats for 10 times.this is how it works
 
 * 1) First, generate a random solution
 * 2) Calculate its energy using getEnergy() method
 * 3)Generate a random neighboring solution
 * 4) Calculate the new solution's energy using getEnergy() method
 * 5) Compare them:
 *          
    If cnew < cold: move to the new solution
    If cnew > cold: maybe move to the new solution

* Repeat steps 3rd setp to 5th step above until an acceptable solution is found or you reach number of iterations.

   // http://katrinaeg.com/simulated-annealing.html
 */

public class SimulatedAnnealing {
    
    private int iterations = 0; // no of iterations algoritham should run
  
     
     public SimulatedAnnealing(){
        
         
         
     }
     
      public SimulatedAnnealing(int iterations){
          
          this();
          this.iterations = iterations;
          
          
      }
      
    public int getIterations() {
        return iterations;
    }

   
    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
    
      public CandidateSolution anneal(){
          
         throw new NotImplementedException();
      }

    
   
      
       
      
      
}
