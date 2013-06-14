import java.util.ArrayList;
import java.util.Random;

public class SimulationController {
	private ArrayList<Animal> animals;
	private Grid grid;
	private static Random r = new Random();
	
	public SimulationController(){
	    animals = new ArrayList<Animal>();
	    grid = new Grid(15, 15);
		
		Animal animal;
		for (int i=0; i<5; i++) {
			animal = new Fox();
			animals.add(animal);
			
			boolean result;
			do {
				int x = r.nextInt(15);
				int y = r.nextInt(15);
				result = grid.addAnimal(animal, x, y);
			} while (!result);
		}
	}	
			
	public static void main(String[] args) {
		SimulationController controller = new SimulationController();
		
	}
		
}
