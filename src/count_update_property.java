import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JPanel;

public class count_update_property extends User_add_count{
	 
	//Properties props_info = new Properties();
	static int key2;

	
		

		public count_update_property() {
			    
				
				
	        }
		public static void changeCountAtKey(int key2, int count_sold) {
			String path = "itemsinfo.properties";
			Properties props_info = new Properties();
			File file = new File(path);
			if (file.exists()) {
			try {
	            props_info.load(new FileInputStream("itemsinfo.properties"));
	        } 
	        catch (IOException ex) {
	            ex.printStackTrace();
	        }
			}
			
			
			for (String key : props_info.stringPropertyNames()) {
                // Check if key starts with a digit and value is not size
				 if (key.matches("\\d+")) {
	
                	if (Integer.parseInt(key) == count_update_property.key2) {
          	
                    String[] values = props_info.getProperty(key).split("/");
                   int a = Integer.parseInt(values[1]) - count_sold;
                   String b = Integer.toString(a);
                   values[1] = b;
                   String new_info = values[0] + "/" + b + "/" + values[2]+ "/" + values[3] + "/" +values[4];
                   System.out.println(new_info);
                   add_read_files.add_intoarray(new_info);
                   add_read_files.add_changed_item();
                      
          
                   }
				 }
            }
		}
		public static void addCountAtKey(int key2, int countAdd) {
			String path = "itemsinfo.properties";
			Properties props_info = new Properties();
			File file = new File(path);
			if (file.exists()) {
			try {
	            props_info.load(new FileInputStream("itemsinfo.properties"));
	        } 
	        catch (IOException ex) {
	            ex.printStackTrace();
	        }
			}
			
			
			for (String key : props_info.stringPropertyNames()) {
                // Check if key starts with a digit and value is not size
				 if (key.matches("\\d+")) {
	
                	if (Integer.parseInt(key) == count_update_property.key2) {
          	
                    String[] values = props_info.getProperty(key).split("/");
                    int a = Integer.parseInt(values[1]) + countAdd;
                   String b = Integer.toString(a);
                   values[1] = b;
                   System.out.println("b ="+b);
                   String new_info = values[0] + "/" + b + "/" + values[2]+ "/" + values[3] + "/" +values[4];
                   System.out.println(new_info);
                   add_read_files.add_intoarray(new_info);
                   add_read_files.add_changed_item();
                   
          
                   }
				 }
            }
		}
		
		public  void passKey(String key1) {
	    	key2 = Integer.parseInt(key1);
	    	}
		
		
		
		public static void main(String[] args) {
			//new count_update_property();
		}
}
