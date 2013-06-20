import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Functions involved in showing the simulation.

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 8750538540874189820L;

	SimulationController controller;
	JLabel[][] labels;
	int xSize, ySize;
	int xSelected = 0, ySelected = 0;
	
	

	public MainPanel(SimulationController controller) {	
		this.controller = controller;
		xSize = controller.getGridSize();
		ySize = controller.getGridSize();
		setLayout(new GridLayout(xSize, ySize));
		labels = new JLabel[xSize][ySize];
		for (int y = 0; y < ySize; y++) {
			for (int x = 0; x < xSize; x++) {
				labels[x][y] = new JLabel("");
				labels[x][y].setOpaque(true);
				labels[x][y].setBorder(BorderFactory.createLineBorder(Color.black));
				labels[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				labels[x][y].setVerticalAlignment(SwingConstants.CENTER);
				add(labels[x][y]);				
			}
		}
		update();
	}

	public void update() {
		Animal animal;
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
			animal = controller.getGrid().getAnimal(x, y);
				if (animal != null) {
					if (animal instanceof Fox){
						labels[x][y].setBackground(Color.RED);
					} else if (animal instanceof Rabbit){
						labels[x][y].setBackground(Color.YELLOW);
					}
					
				}
			}
		}
	}
	
}
