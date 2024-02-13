import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PropertyFileToJTable extends JPanel {

    public JTable table;
    public DefaultTableModel model;
    	
    public PropertyFileToJTable() {
        setSize(400, 300);

        // Create table and model
        table = new JTable();
        model = new DefaultTableModel();
        Object[] column = {"ID","Name", "Count", "Price", "Price Before", "Type"};
        model.setColumnIdentifiers(column);
        table.setModel(model);

        // Read properties file
        Properties props_info = new Properties();
        try {
            props_info.load(new FileInputStream("itemsinfo.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Add data to table model
        	
            for (String key : props_info.stringPropertyNames()) {
                // Check if key starts with a digit
                if (key.matches("\\d+")) {
                    String[] values = props_info.getProperty(key).split("/");
                    model.addRow(new Object[]{key, values[0], values[1], values[2], values[3], values[4]});
                   // System.out.println(props_info.stringPropertyNames());
                }
            }
        }


    public static void main(String[] args) {
    	PropertyFileToJTable pfd =  new PropertyFileToJTable();
    	pfd.setVisible(true);
        
    }
    }

