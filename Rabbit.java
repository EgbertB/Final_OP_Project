
public class Rabbit extends Animal{

	
	public Rabbit(){
		this.age = 0;
		this.energy = 6;
		this.moveCost = 0.40;
		this.metabolism = 4;
		this.vision = 4;
		this.procreateCost = 16;
		this.procreateReq = 10;
	}
	
	// This function handles all of an Agents' behavior in
	// any given step.
	@Override
	public void act() {
		// First, check if the Agent has enough energy to survive
    	// the step, otherwise remove it.
		if (energy < metabolism) {
			remove();
		} else {
			// Let the Agent know it has survived another step.
			age++;

			// 'Cost of living': Subtracting the metabolism from the
			// Agents' energy level.
			energy -= metabolism;
		}
	}

	


	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decide() {
		// TODO Auto-generated method stub
		
	}
	
}
