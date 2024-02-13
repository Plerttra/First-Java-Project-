package Reset_propertyfile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ClearPropertiesFileExample {

    public static void main(String[] args) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("itemsinfo.properties");

            // clear all data from the properties file
            prop.clear();

            // save the empty properties file
            prop.store(output, null);

            System.out.println("Properties file cleared successfully.");

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
