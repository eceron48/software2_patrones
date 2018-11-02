package ingsw.pdd.state;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import ingsw.pdd.state.gui.ServerPanel;

public class StateMain {

	public static void main(String[] args) {
		
		
		
		JFrame frame = new JFrame();
		frame.setTitle("State pattern");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500 ,600);
		frame.setExtendedState(JFrame.NORMAL);
		frame.add(new ServerPanel());
		frame.pack();
		frame.setVisible(true);

	}

}
