import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;

public class SimulationController {
	
	// Simulation variables
	private ArrayList<Animal> animals;
	private Grid grid;
	private static Random r = new Random();
	private int numberOfFoxes = 5;
	private int numberOfRabbits = 5;
	private int gridSize = 30;
	
	// Visualization variables
	private JFrame frame;
	private MainPanel mainPanel;
	
	// Constructor for setting up new animals and adding them to list
	public SimulationController(){
	    initAnimals();			
	}
	
	// This method is called after the simulation is set-up, and creates the GUI
	public void run() {
		createGUI();
		simulationStep();
		//call method run simulation steps over time
	}
	
	//TODO add exception for more animals than gridsize
	// This method is used to create a new ArrayList of type Animal, a new Grid, and different Animals
	// and calls the initAnimal() method to add these to the grid 
	public void initAnimals(){
		animals = new ArrayList<Animal>();
	    grid = new Grid(getGridSize(), getGridSize());
		
		for (int i=0; i<numberOfFoxes; i++) {
			initAnimal(new Fox(this));		
		}
		for (int i=0; i<numberOfRabbits; i++) {
			initAnimal(new Rabbit(this));		
		}
	}
	
	// This method is called by initAnimals() and allows for randomly adding a animal of a certain type to the grid
	public void initAnimal(Animal animal){
		animals.add(animal);
		
		boolean result;
		do {
			int x = r.nextInt(getGridSize());
			int y = r.nextInt(getGridSize());
			result = grid.addAnimal(animal, x, y);
		} while (!result);
	}
	
	// After the simulation is set up, this method is called in order to create a new GUI Frame and Panel
	private void createGUI() {
		frame = new JFrame("Predator-Prey Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new MainPanel(this);
		frame.add(mainPanel);
		
		//frame.setResizable(false);
		frame.setVisible(true);
	}

	
	protected void removeAnimal(Animal animal) {
		animals.remove(animal);
		grid.removeAnimal(animal);
	}
	
	
	public void simulationStep(){	
		Collections.shuffle(animals);
		for(Animal animal:animals){
			animal.act();
		}		
	}

	

	
	
	
	// Main method, which creates a new SimulationController and then starts the simulation run() method 
	public static void main(String[] args) {
		SimulationController simulation = new SimulationController();	
		simulation.run();
	}
	
	// Getters and setters
	protected int getGridSize() {
		return gridSize;
	}

	protected void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	
	protected Grid getGrid(){
		return grid;
	}

		
}
