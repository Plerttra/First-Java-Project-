import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;



public class Ui_menu extends JPanel implements add_read_files {
	DefaultTableModel model = new DefaultTableModel();
	final Object[] row = new Object[5];
	public static int k = add_read_files.returnsize();
	PropertyFileToJTable pfd = new PropertyFileToJTable();
	count_update_property cup = new count_update_property();
	Graphics g;
	
	
	
	
	
	public Ui_menu() {
		
		
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 253, 214));
		frame.setSize(1200,960);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 186, 149));
		panel.setBounds(0, 0, 229, 845);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Used2.HCK");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Water Park", Font.BOLD, 34));
		lblNewLabel.setBounds(20, 180, 188, 116);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add item to inventory");
		lblNewLabel_1.setFont(new Font("Monoglyceride", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 306, 209, 40);
		lblNewLabel_1.addMouseListener (new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				User_add_item uadd = new User_add_item(); 
				uadd.setVisible(true);
			}
		});
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("Profits");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User_profit uprofit = new User_profit();
				uprofit.setVisible(true);
			}
		});
		lblNewLabel_2.setFont(new Font("Monoglyceride", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 375, 103, 22);
		panel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(20, 25, 188, 145);
		ImageIcon cat = new ImageIcon("image/avatar image.jpg");
		Image cat_resize = cat.getImage();
		Image cat_new = cat_resize.getScaledInstance(188,145, java.awt.Image.SCALE_SMOOTH);
		ImageIcon catic_new = new ImageIcon(cat_new);
		lblNewLabel_5.setIcon(catic_new);
		panel.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 433, 229, 412);
		panel_4.setBackground(new Color(230, 186, 149));
		panel.add(panel_4);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(228, 0, 958, 264);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(0, 0, 958, 264);
		ImageIcon img = new ImageIcon("image/ee.jpg");
		Image im_resize = img.getImage();
		Image im_new = im_resize.getScaledInstance(958,264, java.awt.Image.SCALE_SMOOTH);
		ImageIcon imaic_new = new ImageIcon(im_new);
		lblNewLabel_4.setIcon(imaic_new);
		panel_1.add(lblNewLabel_4);
		
			
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		panel_2.setBounds(228, 263, 958, 593);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		/*scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (pfd.table.getSelectedRow()>= 0) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						pfd.model.removeRow(pfd.table.getSelectedRow());
					}
				}
				else {
					JFrame j = new JFrame();
					JOptionPane.showMessageDialog(j, "Please select the row to delete.");
				}
			}
		});*/
		scrollPane.setBounds(37, 25, 880, 307);
		panel_2.add(scrollPane);
		
	    pfd.table.setBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(pfd.table);
		
		JButton btnNewButton = new JButton("Add Count");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pfd.table.getSelectedRow()>=0) {
				int indexRow = pfd.table.getSelectedRow();
				String key1 = pfd.table.getValueAt(indexRow, 0).toString();
				cup.passKey(key1);
				new User_add_count();
				
				}
				else {
					
						JFrame j = new JFrame();
						JOptionPane.showMessageDialog(j, "Please select the row to add.");
				}
			}
		});
		btnNewButton.setBounds(37, 371, 122, 39);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pfd.table.getSelectedRow()>= 0) {
					JFrame jf = new JFrame();
					if (JOptionPane.showConfirmDialog(jf, "Comfirm?", "Comfirm to Delete Product", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					int indexRow = pfd.table.getSelectedRow();
					String key1 = pfd.table.getValueAt(indexRow, 0).toString();
					pfd.model.removeRow(pfd.table.getSelectedRow());
					delete_dataAtRow.passKey(key1);
					delete_dataAtRow.delete_rowData();
				}
				}
				else {
					JFrame j = new JFrame();
					JOptionPane.showMessageDialog(j, "Please select the row to delete.");
				}
			
		}
		});
		btnNewButton_1.setBounds(180, 371, 111, 39);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sell");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
					if (pfd.table.getSelectedRow()>= 0) {
						User_sell usell = new User_sell();
						int indexRow = pfd.table.getSelectedRow();
						String key1 = pfd.table.getValueAt(indexRow, 0).toString();
						String name = pfd.table.getValueAt(indexRow, 1).toString();
						String count = pfd.table.getValueAt(indexRow, 2).toString();
						String price = pfd.table.getValueAt(indexRow, 3).toString();
						String pricebf = pfd.table.getValueAt(indexRow, 4).toString();
						String type = pfd.table.getValueAt(indexRow, 5).toString();
	
						
						usell.tf1.setText(name);
						usell.tf2.setText(count);
						usell.tf3.setText(price);
						usell.tf4.setText(pricebf);
						usell.tf5.setText(type);
						cup.passKey(key1);
						usell.passValue(count,price, pricebf);
						//System.out.println("row " +indexRow);
						
						
	
					}
					else {
						JFrame j = new JFrame();
						JOptionPane.showMessageDialog(j, "Please select the row to sell.");
					}
				
				}
			});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_2.setBounds(309, 371, 96, 39);
		panel_2.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Ui_menu ui = new Ui_menu();
				frame.getContentPane().add(ui);
			}
		});
	
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_3.setBounds(430, 371, 96, 39);
		panel_2.add(btnNewButton_3);
		
		JCheckBox chckbxOwner = new JCheckBox("About the Owner");
		chckbxOwner.setBackground(new Color(245, 222, 179));
		chckbxOwner.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chckbxOwner.setBounds(47, 472, 145, 39);
		panel_2.add(chckbxOwner);
		
		JCheckBox chckbxDefault = new JCheckBox("Hide");
		chckbxDefault.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		chckbxDefault.setBackground(new Color(245, 222, 179));
		chckbxDefault.setBounds(194, 472, 96, 39);
		panel_2.add(chckbxDefault);
		
		JLabel lblNewLabel_3 = new JLabel("*For ADD COUNT use only once at a time if you need to add more pls restart the program*");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(37, 400, 409, 66);
		panel_2.add(lblNewLabel_3);
		
		
		g = panel_4.getGraphics();
		panel_4.paintComponents(g);
		chckbxOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxDefault.setSelected(false);
				ImageIcon icon = new ImageIcon("image/nam1.png");
				Image image = icon.getImage();
				g.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				g.setColor(Color.BLACK);
				g.drawString("Hathaichanok (Nam) is a young girl", 5, 30);
				g.drawString("who dreams of owning bussinesses",5, 50);
				g.drawString("since she was 15 and now she owns",5, 70);
				g.drawString("a online thrift shop on Instagram...",5, 90);
				g.setFont(new Font("Water Park", Font.BOLD, 70));
				g.drawString("Nam",50, 150);
				g.drawString("Nam",50, 200);
				g.drawString("Nam",50, 250);
				g.drawImage(image, 0, 100, 229, 250, null);
				int x = 0;
				int c = 76;
				for (int i = 0 ; i <= 12 ; i++) {
					g.setColor(new Color(c,c-1,c-54));
					g.fillOval(x, 350, 10, 10);
					x+=20;
					c+=10;
					}
				x = 0;
				c = 76;
				for (int i = 0 ; i <= 12 ; i++) {
					g.setColor(new Color(c,c-1,c-54));
					g.fillRect(x+10, 350, 10, 10);
					x+=20;
					c+=10;
				}
				
			}
		});
		chckbxDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxOwner.setSelected(false);
				panel_4.repaint();
			}
			});
		

		
		frame.repaint();
		pfd.model.fireTableDataChanged();
		//System.out.println(k);
		
		}
	
	public static void main(String[] args) {
	       new Ui_menu();
	}
}

