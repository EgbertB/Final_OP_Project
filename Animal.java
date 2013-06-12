
public abstract class Animal {
	
	// Attributes
	private int xPosition;
    private int yPosition;
    private int age;
    private double energy;
    private int turnCost;
    
    //comment van diederik
    //comment van sebas
    //comment van sebas 2
    public abstract Animal (Simulation sim){
    	
    }
    
    abstract public void die();
    
    public abstract void act();
    
    public abstract void look();
    
    public abstract void decide();
    
}
