
package cs.pkgfinal.project.lib;

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
    
    private long iterations = 0; // no of iterations algoritham should run
    private PreferenceTable preferenceTable;
     
     public SimulatedAnnealing(){
        
         
         
     }
     
      public SimulatedAnnealing(long iterations){
          
          this();
          this.iterations = iterations;
          
          
      }
      
       public SimulatedAnnealing(PreferenceTable preferenceTable,long iterations){
          
          this(iterations);
          this.preferenceTable = preferenceTable;
          
          
      }
      
    public long getIterations() {
        return iterations;
    }

   
    public void setIterations(long iterations) {
        this.iterations = iterations;
    }
    
    
   
    public PreferenceTable getPreferenceTable() {
        return preferenceTable;
    }

  
    public void setPreferenceTable(PreferenceTable preferenceTable) {
        this.preferenceTable = preferenceTable;
    }
    
    
    
      public CandidateSolution anneal(){
          
          CandidateSolution currentSolution = new CandidateSolution(this.preferenceTable);
          
         
         
          double T  = 1.0;
          double  T_min = 0.00001;
          double A = 0.9;
          
           while (T > T_min){
               
            for(int i=0;i<this.iterations;i++){

              CandidateSolution candidateSolution =   new CandidateSolution(this.preferenceTable);
              
              if( candidateSolution.getEnergy() < currentSolution.getEnergy()){

                  currentSolution = candidateSolution;
              }

               T = T*A;
            }
           }
          
          return currentSolution;
          
       
      }

    
   
      
       
      
      
}
