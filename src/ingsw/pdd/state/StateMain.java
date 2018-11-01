package ingsw.pdd.state;

import javax.swing.JFrame;
import ingsw.pdd.state.gui.ServerPanel;

public class StateMain {

	public static void main(String[] args) {
		
		
		
		JFrame frame = new JFrame();
		frame.setTitle("State pattern");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ServerPanel());
		frame.pack();
		frame.setVisible(true);

	}

}
