import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




public class User_sell extends JPanel  {
	JFrame frame = new JFrame("Sell Items");
	static long allProfit;
	
	PropertyFileToJTable pfd = new PropertyFileToJTable();
	count_update_property cup = new count_update_property();
	JPanel p1 =  new JPanel();
	JButton bt1 = new JButton("Okay");
	JButton bt2 = new JButton("Cancle");
	JTextField tf1 = new JTextField(30);
	JTextField tf2 = new JTextField(30);
	JTextField tf3 = new JTextField(30);
	JTextField tf4 = new JTextField(30);
	JTextField tf5 = new JTextField(30);
	JTextField tf6 = new JTextField(30);
	JTextField tf7 = new JTextField(30);
	JTextField tf8 = new JTextField(30);
	JLabel l1 = new JLabel("Name:");
	JLabel l2 = new JLabel("Count:");
	JLabel l3 = new JLabel("Price:");
	JLabel l4 = new JLabel("Price Before:");
	JLabel l5 = new JLabel("Type:");
	JLabel l6 = new JLabel("CountToSell:");
	JLabel l7 = new JLabel("Delivery Charge:");

	ActionInterpretor AP = new ActionInterpretor(); 
	String m1 = "";
	int m2;
	int m3;
	int m4;
	String m5;
	int m6;
	int count_in_stock;
	
	Timer timer;
	int second = 6;
	JLabel sec = new JLabel();

	
	public User_sell() {
	p1.setLayout(new FlowLayout());
	p1.add(l1);
	p1.add(tf1);
	p1.add(l2);
	p1.add(tf2);
	p1.add(l3);
	p1.add(tf3);
	p1.add(l4);
	p1.add(tf4);
	p1.add(l5);
	p1.add(tf5);
	p1.add(l6);
	p1.add(tf6);
	p1.add(l7);
	p1.add(tf7);
	p1.add(tf8);
	p1.add(bt1);
	p1.add(bt2);
	p1.add(sec);
	tf1.setEditable(false); 
	tf2.setEditable(false); 
	tf3.setEditable(false); 
	tf4.setEditable(false); 
	tf5.setEditable(false); 
	tf8.setEditable(false); 
	bt1.addActionListener(AP);
	
	bt2.addActionListener( new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		JFrame j = new JFrame();
		if (JOptionPane.showConfirmDialog(j, "Comfirm if you want to cancle", "Cancle", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			frame.setVisible(false);
		}
		}
	});
	 
	sec.setForeground(Color.RED);
	
	
	frame.add(p1, BorderLayout.CENTER);
	frame.setSize(350, 450); //set a frame's resolution
	frame.setLocationRelativeTo(null); //set a location at center the frame
	frame.setVisible(true); //set visible
	//frame.setDefaultCloseOperation(JPanel.ABORT);
	

	

	}
	class ActionInterpretor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bt1) {
				calculate_profit(m3,m4);
			}
				
		}
		
}
	public void passValue(String count,String price, String pricebf) {
		count_in_stock = Integer.parseInt(count);
		m3 = Integer.parseInt(price);
		m4 = Integer.parseInt(pricebf);

	}
	public void  calculate_profit(int m3,int m4) {
		m2 = Integer.parseInt(tf6.getText().toString());
		m6 = Integer.parseInt(tf7.getText().toString());
		if (m2 <= count_in_stock) {
		//cup.passCountSold(m2);
		int key = count_update_property.key2;	
		count_update_property.changeCountAtKey(key, m2);
		int r = (m2*(m3-m4)) - m6;
		allProfit += r; // implicit
		String profit = String.valueOf(r);
		tf8.setText(profit);
		System.out.println(allProfit);
		countdown();
		timer.start();
		
		}
		else {
			JFrame j = new JFrame();
			if (JOptionPane.showConfirmDialog(j, "Number of products in stock is not enough to sell. Please check your input", "Error", JOptionPane.CLOSED_OPTION) == JOptionPane.CLOSED_OPTION) {
				frame.setVisible(false);
			}
		}
	}
	
	public void countdown() {
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second--;
				String a = Integer.toString(second);
				sec.setText(a);
				if (second == 0) {
					timer.stop();
					frame.setVisible(false);
					new User_profit();
				}
			}
		}); 
			
		
	}

	public static void main (String[] args) {
		//new User_sell();
		
	}
}
