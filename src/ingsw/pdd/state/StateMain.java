package ingsw.pdd.state;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import ingsw.pdd.state.gui.ServerPanel;

public class StateMain {

	public static void main(String[] args) {
		
		
		
		JFrame frame = new JFrame();
		frame.setTitle("State pattern");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.add(new ServerPanel());
		//frame.pack();
		frame.setVisible(true);

	}

}
