package provaClient;

import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame {
	private JPanel pannelloSup=new JPanel();
	private JPanel pannelloInf=new JPanel();
	
	private JTextField input=new JTextField(20);
	
	private JLabel placeS=new JLabel(" Place: ");
	private JLabel placeR=new JLabel("          ");
	private JLabel magnS=new JLabel(" Magn: ");
	private JLabel magnR=new JLabel("          ");
	private JLabel timeS=new JLabel(" Time: ");
	private JLabel timeR=new JLabel("          ");
	
	private JButton b_start =new JButton("Start");
	private Listerner listener= new Listerner(this);
	
	public GUI() {
		setup();
	}

	private void setup() {
		pannelloSup.setLayout(new FlowLayout());
		pannelloSup.add(placeS);
		pannelloSup.add(placeR);
		pannelloSup.add(magnS);
		pannelloSup.add(magnR);
		pannelloSup.add(timeS);
		pannelloSup.add(timeR);
		
		b_start.addActionListener(listener);
		b_start.setActionCommand(Listerner.START);
		pannelloInf.add(input);
		pannelloInf.add(b_start);
		
		this.setTitle("ClientProva");
		this.getContentPane().add(pannelloSup, BorderLayout.NORTH);
		this.getContentPane().add(pannelloInf, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,100);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setPlaceR(String s) {
		this.placeR.setText(s);
	}

	public void setMagnR(String s) {
		this.magnR.setText(s);
	}

	public void setTimeR(String s) {
		this.timeR.setText(s);
	}
	
	public String getInput() {
		return this.input.getText();
	}
}
