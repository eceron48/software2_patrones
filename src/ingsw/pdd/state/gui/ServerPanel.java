package ingsw.pdd.state.gui;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import ingsw.pdd.state.Server;
import ingsw.pdd.state.states.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ServerPanel extends javax.swing.JPanel {


	private static final long serialVersionUID = 1L;
	private Server server;
	private int messageCouter;
	public JButton btnIniciar;
	public JTextArea txtAreaMensaje;

	public ServerPanel() {
		initComponents();	
		setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(10, 25, 333, 72);
		add(btnIniciar);

		JButton btnEnviarMensaje = new JButton("EnviarMensaje");
		btnEnviarMensaje.setBounds(10, 244, 430, 30);
		add(btnEnviarMensaje);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ServerPanel.class.getResource("/META_INF/Server.png")));
		lblNewLabel.setBounds(353, 25, 70, 72);
		add(lblNewLabel);

		JTextArea txtAreaMensaje = new JTextArea();
		txtAreaMensaje.setBounds(10, 108, 430, 119);
		add(txtAreaMensaje);
	

		PrintStream defaultPrinter = System.out;
		PrintStream interceptor = new TextAreaPrinter(defaultPrinter);
		System.setOut(interceptor);
	
		server = new Server();
	}

	
	@SuppressWarnings("unused")
	private void initComponents() {
		
		
		

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
			line = line + "\n";
			super.print(line);
			txtAreaMensaje.append(line);
			txtAreaMensaje.setCaretPosition(txtAreaMensaje.getDocument().getLength());
		}
	
		
	}


	@SuppressWarnings("unused")
	private void sendMessageEvent(java.awt.event.ActionEvent evt) {
		server.handleMessage("Send Message + "+messageCouter);

	}
	
	@SuppressWarnings("unused")
	private void startAction(java.awt.event.ActionEvent evt) {

		AbstractServerState state = server.getState();
		if (state instanceof StopServerState) {
			btnIniciar.setText("Stop");
			server.setState(new StartingServerState(server));
		} else {
			if (state instanceof StartingServerState) {
				server.setState(new StopServerState(server));
			} else {
				btnIniciar.setText("Start");
				server.setState(new StopServerState(server));
			}
		}
		
	}
}
