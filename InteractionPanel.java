import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class InteractionPanel extends JPanel {
	private static final long serialVersionUID = -641820169753588757L;
	
	SimulationController controller;
	JTextPane info;
	
	
	public InteractionPanel(final SimulationController controller) {	
		this.controller = controller;
		
		JButton button = new JButton("Next Step");
        //Add action listener to button
        button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
                controller.simulationStep();
            }
        });    
		
        this.add(button);
	}	

}
