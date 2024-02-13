import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class delete_dataAtRow {
	static int keyToDelete;
    delete_dataAtRow() {

    }

    public static void delete_rowData() {
        String path = "itemsinfo.properties";
        Properties props_info = new Properties();
        File file = new File(path);
        if (file.exists()) {
            try {
                props_info.load(new FileInputStream(path));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (String key : props_info.stringPropertyNames()) {
            // Check if key starts with a digit and value is not size
            if (key.matches("\\d+")) {
                if (Integer.parseInt(key) == delete_dataAtRow.keyToDelete) {
                	props_info.remove(key);
                }
            }
        }


        try {
            props_info.store(new FileOutputStream(path), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void passKey(String key1) {
    	keyToDelete = Integer.parseInt(key1);
    	//System.out.println(key2 + "f");
    	}
}

