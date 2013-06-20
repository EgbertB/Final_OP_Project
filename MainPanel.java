import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

// Functions involved in showing the simulation.

public class MainPanel extends JPanel implements MouseInputListener {
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
		addMouseListener(this);
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


	// Methods required by the MouseInputListener interface.
	public void mouseClicked(MouseEvent e) {
		labels[xSelected][ySelected].setBorder(BorderFactory.createLineBorder(Color.black));
		xSelected = e.getX() / (650 / xSize);
		ySelected = e.getY() / (650 / ySize);
		labels[xSelected][ySelected].setBorder(BorderFactory.createLineBorder(Color.red));
		//scape.buttonPanel.addInfo(scape.grid[xSelected][ySelected]);
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}
}
