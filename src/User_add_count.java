import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class User_add_count {
	JFrame frame = new JFrame("Add Count");
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel("Add the number you want");
	JTextField tf1 = new JTextField(30);
	JButton bt1  = new JButton("Okay");
	JButton bt2 = new JButton("Cancle");
	static int countAdd;
	
	User_add_count(){
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame j = new JFrame();
				if (JOptionPane.showConfirmDialog(j, "Comfirm?", "Comfirm to Add Count", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				countAdd = Integer.parseInt(tf1.getText());
				count_update_property.addCountAtKey(count_update_property.key2, countAdd);
				frame.setVisible(false);
				}
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		p1.setLayout(new FlowLayout());
		p1.add(l1);
		p1.add(tf1);
		p1.add(bt1);
		p1.add(bt2);
		
		frame.add(p1, BorderLayout.CENTER);
		frame.setSize(350, 150); //set a frame's resolution
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visible
	}
	
	 
	
	public static void main(String[] args) {
		new User_add_count();
	} 
}
