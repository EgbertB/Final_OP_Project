import java.util.ArrayList;


public class SimulationModel {
	
	private ArrayList<Animal> animals;
	private Grid grid;
	
	public SimulationModel(){
	    this.animals = new ArrayList<Animal>();
	    this.grid = new Grid();
	}	
	
	public void addAnimal(Animal a){
		animals.add(a);
		
	}
	
}
