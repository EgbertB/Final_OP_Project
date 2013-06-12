
public abstract class Animal {
	
	// Attributes
	private int xPosition;
    private int yPosition;
    private int age;
    private double energy;
    private int turnCost;
    
    //comment van diederik
    public abstract Animal (Simulation sim){
    	
    }
    
    abstract public void die();
    
    public abstract void act();
    
    public abstract void look();
    
    public abstract void decide();
    
}
