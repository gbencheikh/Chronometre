package Programme;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StopWatch implements ActionListener{
	JFrame JF = new JFrame() ; 
	JButton JB_start = new JButton("START"); 
	JButton JB_stop = new JButton("STOP"); 
	JButton JB_reset = new JButton("RESET"); 
	JLabel timeLabel = new JLabel(); 
	
	int elapsedTime = 0; 
	
	int seconds = 0; 
	int minutes = 0; 
	int heures = 0; 
	
	boolean start = false; 
	
	String second_string = String.format("%02d", seconds); 
	String minute_string = String.format("%02d", minutes); 
	String heur_string = String.format("%02d", heures); 
	
	Timer timer = new Timer(1000,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elapsedTime += 1000; 
			heures = (elapsedTime/360000); 
			minutes = (elapsedTime/60000) % 60 ; 
			seconds = (elapsedTime/1000) % 60; 
			
			// update strings 
			second_string = String.format("%02d", seconds);
			minute_string = String.format("%02d", minutes);
			heur_string = String.format("%02d", heures); 
			
			timeLabel.setText(heur_string+":"+minute_string+":"+second_string);
			
		}
	});
	
	StopWatch(){
		timeLabel.setText(heur_string+":"+minute_string+":"+second_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true); 
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		JB_start.setBounds(100,200,100,50); 
		JB_start.setFont(new Font("Ink Free",Font.PLAIN, 20));
		JB_start.setFocusable(false); 
		JB_start.addActionListener(this);
		
		JB_stop.setBounds(100,200,100,50); 
		JB_stop.setFont(new Font("Ink Free",Font.PLAIN, 20));
		JB_stop.setFocusable(false); 
		JB_stop.addActionListener(this);
		
		JB_reset.setBounds(200,200,100,50); 
		JB_reset.setFont(new Font("Ink Free",Font.PLAIN, 20));
		JB_reset.setFocusable(false); 
		JB_reset.addActionListener(this);
		
		JF.add(timeLabel);
		JF.add(JB_start);
		JF.add(JB_stop); 
		JF.add(JB_reset);
		
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.setSize(420,420); 
		JF.setTitle("Chronometre"); 
		JF.setLayout(null);
		JF.setVisible(true); 
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JB_start) {
			
			if(start == false) {
				start = true; 
				JB_start.setText("STOP");
				start(); 
			}else {
				start = false; 
				JB_start.setText("START");
				stop(); 
			}
		}else {
			if(e.getSource() == JB_reset) {
				if(start == true) {
					JB_start.setText("START");
					stop(); 
				}
				reset();
			}
		}
	}
	
	void start() {
		timer.start();
	}
	void stop() {
		timer.stop(); 
	}
	void reset() {
		timer.stop(); 
		elapsedTime = 0; 
		heures = 0; 
		minutes = 0; 
		seconds = 0; 
		
		second_string = String.format("%02d", seconds);
		minute_string = String.format("%02d", minutes);
		heur_string = String.format("%02d", heures); 
		
		timeLabel.setText(heur_string+":"+minute_string+":"+second_string);
		
	}
	
	public static void main(String[] args) {
		StopWatch S = new StopWatch(); 
		
	}
}