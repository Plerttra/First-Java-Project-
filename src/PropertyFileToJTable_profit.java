import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import javax.swing.JPanel;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
public class PropertyFileToJTable_profit extends JPanel {
	

	    public JTable table;
	    public DefaultTableModel model;
	    	
	    public PropertyFileToJTable_profit() {
	        setSize(400, 300);

	        // Create table and model
	        table = new JTable();
	        model = new DefaultTableModel();
	        Object[] column = {"ID","Profits", "Date"};
	        model.setColumnIdentifiers(column);
	        table.setModel(model);

	        // Read properties file
	        Properties props_info = new Properties();
	        try {
	            props_info.load(new FileInputStream("profits.properties"));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }

	        // Add data to table model
	       
	            // Check if key starts with a digit (to exclude comments and size property)
	        	
	            for (String key : props_info.stringPropertyNames()) {
	                // Check if key starts with a digit and value is not size
	                if (key.matches("\\d+")) {
	                    String[] values = props_info.getProperty(key).split(",");
	                    model.addRow(new Object[]{key, values[0], values[1]});
	                    //System.out.println(key);
	                }
	            }
	        }

	}

