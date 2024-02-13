import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


public class User_add_item extends JPanel implements add_read_files  {
	
	JPanel p1 = new JPanel();
	JButton bt1 = new JButton("Browse");
	JButton bt2 = new JButton("Add");
	JTextField tf1 = new JTextField(30);
	JTextField tf2 = new JTextField(30);
	JTextField tf3 = new JTextField(30);
	JTextField tf4 = new JTextField(30);
	JTextField tf5 = new JTextField(30);
	JLabel l1 = new JLabel("Name:");
	JLabel l2 = new JLabel("Count:");
	JLabel l3 = new JLabel("Price:");
	JLabel l4 = new JLabel("Price Before:");
	JLabel l5 = new JLabel("Type:");
	JLabel l6 = new JLabel();
	
	ActionInterpretor AP = new ActionInterpretor();

	public User_add_item() {
		
		JFrame frame = new JFrame();
		frame.add(p1, BorderLayout.CENTER);
		frame.setSize(350, 550);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JPanel.ABORT);
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
		p1.add(bt1);
		p1.add(bt2);
		p1.add(l6);
		bt1.addActionListener(AP);
		bt2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				JFrame j = new JFrame();
				if (JOptionPane.showConfirmDialog(j, "Comfirm?", "Comfirm to Add Product", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					String info = tf1.getText() + "/" + tf2.getText() + "/" + tf3.getText() + "/" + tf4.getText() + "/" + tf5.getText();
					add_read_files.add_intoarray(info);
					add_read_files.add_item();
					frame.setVisible(false);
					}
					
				}
		});


	}

	class ActionInterpretor implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bt1) {
				JFileChooser browseImageFile = new JFileChooser();
				// Filter image extensions
				browseImageFile.addChoosableFileFilter(new FileNameExtensionFilter("JPEG file", "jpg", "jpeg"));
				int showOpenDialogue = browseImageFile.showOpenDialog(null);
				if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					JOptionPane.showMessageDialog(null, selectedImagePath);
					// Display image
					ImageIcon imaic = new ImageIcon(selectedImagePath);
					Image im_resize = imaic.getImage();
					Image im_new = im_resize.getScaledInstance(200,200, java.awt.Image.SCALE_SMOOTH);
					ImageIcon imaic_new = new ImageIcon(im_new);
					l6.setIcon(imaic_new);
					}
				}
		}
	}
	public static void main(String[] args) {
		new User_add_item();
		
	}
}
