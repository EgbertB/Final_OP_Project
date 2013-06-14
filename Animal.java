import java.util.Vector;


public abstract class Animal {
	
	// Attributes
	protected int xPosition;
    protected int yPosition;
    protected int age;
    protected double energy;
    protected double metabolism;
    protected double moveCost;
    protected int vision;
    protected int procreateReq;
    protected int procreateCost;
    
    
    // The remove and look methods are general Agent methods
    public void remove(){
    	// When an Agent dies, remove it from the Agent Vector, and remove
        // it from the Site it was on.
    	
    	//sim.agents.remove(this);
   		//sim.grid[xPosition][yPosition].setAgent(null);
    	
    }
    
    public void look(){
    	
    }
    
    
    // The Act and decide methods are abstract and should be implemented by a concrete subclass
    public abstract void act();

    public abstract void decide();
    
    
}
