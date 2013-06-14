
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
    
    abstract public void remove();
    
    public abstract void act();
    
    public abstract void look();
    
    public abstract void decide();
    
}
