
public class Rabbit extends Animal{

	
	public Rabbit(SimulationController controller){
		super(controller);
		this.age = 0;
		this.energy = 6;
		this.moveCost = 0.40;
		this.metabolism = 4;
		this.vision = 4;
		this.procreateCost = 16;
		this.procreateReq = 10;
	}
	
	
	
	@Override
	public void decide() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void act(){
		super.act();	
	}
	
}
