import java.util.Observable;




public abstract class Animal {
	
	// Attributes
    protected int age;
    protected double energy;
    protected double metabolism;
    protected double moveCost;
    protected int vision;
    protected int procreateReq;
    protected int procreateCost;
    
    protected SimulationController simulationController;
    
    // Constructor which receives a reference to the controller
    public Animal(SimulationController controller) {
		this.simulationController = controller;
	}

	// The remove and look methods are general Agent methods
    public void remove(){
    	// When an Agent dies, remove it from the Agent Vector, and remove
        // it from the Site it was on.
    	
    	simulationController.removeAnimal(this);
    }
    
    public void look(){
    	Animal[][] surrounding = simulationController.getGrid().getSurrounding(this);    	
    }
    
    // This function handles all of an Agents' behavior in
 	// any given step.
 	public void act() {
 		// First, check if the Agent has enough energy to survive
     	// the step, otherwise remove it.
 		if (energy <= 0) {
 			remove();
 		} else {
 			// Let the Agent know it has survived another step.
 			age++;

 			// 'Cost of living': Subtracting the metabolism from the
 			// Agents' energy level.
 			energy -= metabolism;
 		}
 	}


    public abstract void decide();
    
    
    
}
