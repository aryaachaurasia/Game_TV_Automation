package utilityClasses;

import java.io.FileReader;
import java.util.Properties;

//to read config reader
public class ConfigPropertyReader {

	    private static String defaultConfigFile = "./Config.properties";
	  
	    public static String getProperty(String propFile, String Property) {
	        try {
	        	
	        	FileReader reader=new FileReader(propFile); 
	        	Properties prop=new Properties();
	            prop.load(reader);
	            return prop.getProperty(Property);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	    
	    public static String getProperty(String property){
	        return getProperty(defaultConfigFile, property);
	    }
}
