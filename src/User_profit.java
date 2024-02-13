import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class User_profit extends JPanel {
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel("Your Currently Profit is");
	JButton b1 = new JButton("Reset and Save");
	JLabel l2 = new JLabel();
	
	private int a; 
	String b;
	JTextField tf1 = new JTextField(20);
	
	PropertyFileToJTable_profit p = new PropertyFileToJTable_profit();
	User_profit() {
	
		JFrame frame = new JFrame();
		dateTime();
		frame.add(p1);
		frame.setSize(500, 550);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		p1.setLayout(new FlowLayout());
		p1.add(l1);
		p1.add(tf1);
		a = (int)User_sell.allProfit; //explicit
		b = Integer.toString(a);
		tf1.setText(b);
		tf1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tf1.setEditable(false);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame();
				if (JOptionPane.showConfirmDialog(j, "Comfirm?", "Comfirm to Reset Profit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				String info = b + "," + l2.getText(); 
				add_read_files.add_profit_intoarray(info);
				add_read_files.add_profit();
				User_sell.allProfit = 0;
				frame.setVisible(false);
				User_profit us = new User_profit();
				frame.add(us);
			}
		}
		});
		p1.add(b1);
		p1.add(l2);
		
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(50, 100, 307, 307);
		p1.add(scrollPane);
		
	    p.table.setBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(p.table);
		
		frame.add(p1);
		frame.repaint();
		
	      
	}
	protected void dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		l2.setText(dtf.format(now));
	}
	
	public static void main(String[] args) {
		new User_profit();
	}
}
