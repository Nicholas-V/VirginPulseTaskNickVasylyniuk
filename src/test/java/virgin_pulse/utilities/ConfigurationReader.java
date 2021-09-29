package virgin_pulse.utilities;

import java.io.*;
import java.util.Properties;

public class ConfigurationReader {
    //#1 Create property object
    private static Properties properties = new Properties();

    static{
        //#2 Load the file into FileInputStream
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            //#3 properties object with the file ("configuration.properties")
            properties.load(file);

        } catch (IOException e) {
            System.out.println("File not found in Configuration properties.");
        }

    }
    public static String getProperty(String keyWord){

        return properties.getProperty(keyWord);
    }

}
