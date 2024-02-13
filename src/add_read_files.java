
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public interface add_read_files {

	public static ArrayList<String> items = new ArrayList<String>();
	public static ArrayList<String> profits = new ArrayList<String>();
	//public static ArrayList<String> items_price = new ArrayList<String>();
	//public static ArrayList<String> items_pricebf = new ArrayList<String>();
	//public static ArrayList<String> items_type= new ArrayList<String>();
	Properties props = new Properties();
	static int j  =  returnsize();
	static int k = returnsize_profit();
	
	public static void add_intoarray(String info) {
		items.add(info);
	}
	public static void add_profit_intoarray(String info) {
		profits.add(info);
	}
	

	public static void add_item() {
		// Read if there is an existing file
		String path = "itemsinfo.properties";
		Properties props = new Properties();
		File file = new File(path);
		if (file.exists()) {
			try (FileInputStream inputStream = new FileInputStream(file)){
				props.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// add the new data 
		int i = j;
		// Populating the properties file
		props.put("size", items.size() + j +  "");
		for (String item : items) {
			props.put(i + "", item);
			i++;
		}
		// Write the properties object back to the file
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            props.store(outputStream, "This is a sample properties file");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void add_changed_item() {

		// items.add("Paper");items.add("Eraser");items.add("Pen");items.add("Pencil");
		// Read if there is an existing file
		String path = "itemsinfo.properties";
		Properties props = new Properties();
		File file = new File(path);
		if (file.exists()) {
			try (FileInputStream inputStream = new FileInputStream(file)){
				props.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// add the new data 
		int i = count_update_property.key2;
		// Populating the properties file
		props.put("size", items.size()+count_update_property.key2 +  "");
		for (String item : items) {
			props.put(i + "", item);
			i++;
		}
		// Write the properties object back to the file
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            props.store(outputStream, "This is a sample properties file");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

	

	public static void read_item() {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream("itemsinfo.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int size = Integer.parseInt(prop.getProperty("size").toString());
		for (int i = 0; i < size; i++) {
			String item = prop.getProperty(i + "").toString();
			items.add(item);
		}

		System.out.println(items.toString());
	}

	public static void add_profit() {
		// items.add("Paper");items.add("Eraser");items.add("Pen");items.add("Pencil");
		// Read if there is an existing file
		String path = "profits.properties";
		Properties props = new Properties();
		File file = new File(path);
		if (file.exists()) {
			try (FileInputStream inputStream = new FileInputStream(file)){
				props.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// add the new data 
		int i = k;
		// Populating the properties file
		props.put("size", profits.size() + k +  "");
		for (String item : profits) {
			props.put(i + "", item);
			i++;
		}
		// Write the properties object back to the file
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            props.store(outputStream, "This is a sample properties file");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static int returnsize() {
		String path = "itemsinfo.properties";
		Properties props = new Properties();
		File file = new File(path);
		if (file.exists()) {
			try (FileInputStream inputStream = new FileInputStream(file)){
				props.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int size1 = Integer.parseInt(props.getProperty("size").toString());
		//System.out.println(size1);
		return size1;
		
		
		
	}
	
	public static int returnsize_profit() {
		String path = "profits.properties";
		Properties props = new Properties();
		File file = new File(path);
		if (file.exists()) {
			try (FileInputStream inputStream = new FileInputStream(file)){
				props.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int size1 = Integer.parseInt(props.getProperty("size").toString());
		System.out.println(size1);
		return size1;
		
		
		
	}
	

	public static void main(String[] args) {
		// add_item();
		//profits.add("0,2023/05/4 17:25:40");
		//add_profit();
		//System.out.println(profits);
		// add_itemCount();
		// add_itemPrice();
		// add_itemPriceBefore();
		// add_itemDeliveryCharge();
		// read_item();
		// System.out.println(j);
		// read_itemPrice();
		// read_itemPriceBefore();
		// read_itemDeliveryCharge();
		//returnsize();

	}
}
