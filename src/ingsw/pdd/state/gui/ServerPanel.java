package ingsw.pdd.state.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import ingsw.pdd.state.Server;
import ingsw.pdd.state.states.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ServerPanel extends javax.swing.JPanel implements ActionListener {

	private Server server;
	private int messageCouter;
	private JTextArea jTextArea1;
	private JButton btnStart;
	private JButton btnMensaje;


	
	public ServerPanel() {
		setLayout(null);
		setAlignmentY(Component.BOTTOM_ALIGNMENT);
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setBorder(new TitledBorder(null, "starter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		initComponents();
	
	
		
		
		PrintStream defaultPrinter = System.out;
		PrintStream interceptor = new TextAreaPrinter(defaultPrinter);
		System.setOut(interceptor);
		server = new Server();
	
		
		
		btnStart=new JButton("Start");
		btnStart.setBounds(52, 31, 102, 23);
		add(btnStart);
		btnStart.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(315, 16, 125, 114);
		add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ServerPanel.class.getResource("/META_INF/Server.png")));
		
		btnMensaje=new JButton("Mensaje");
		btnMensaje.setBounds(58, 289, 174, 23);
		add(btnMensaje);
		btnMensaje.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 118, 300, 91);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		
		jTextArea1= new JTextArea();
		jTextArea1.setBounds(7, 118, 298, 72);
		add(jTextArea1);
	}

	private class TextAreaPrinter extends PrintStream {

		public TextAreaPrinter(OutputStream out) {
			super(out, true);
		}

		@Override
		public void print(String line) {
			println(line);
		}

		@Override
		public void println(String line) {
			jTextArea1= new JTextArea();
			jTextArea1.setBounds(50, 50, 200, 200);
			add(jTextArea1);
			line = line + "\n";
			super.print(line);
			jTextArea1.append(line);
			jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
		}

	}

	private void initComponents() {
	}

	private void sendMessageEvent(java.awt.event.ActionEvent evt) {
		server.handleMessage("Send Message + " + ++messageCouter);
 	}

	private void startAction(java.awt.event.ActionEvent evt) {
		AbstractServerState state = server.getState();
		if (state instanceof StopServerState) {
			btnStart.setText("Stop");
			server.setState(new StartingServerState(server));
		} else {
			if (state instanceof StartingServerState) {
				server.setState(new StopServerState(server));
			} else {
				btnStart.setText("Start");
				server.setState(new StopServerState(server));
			}
		}

 }

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==btnStart) {
			startAction(evt);
		}
		else if(evt.getSource()==btnMensaje) {
			sendMessageEvent(evt);
		}
		
	}
}