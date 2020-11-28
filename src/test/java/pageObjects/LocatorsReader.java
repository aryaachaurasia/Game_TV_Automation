package pageObjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//to read Locator file so as 
//different locator file to add all the locators at one place

public class LocatorsReader {

	private static Map<String, List<String>> readSpecFile(){
		Map<String, List<String>> pageObjects = new HashMap<String, List<String>>();
		try
		{
			File file = new File("src/test/resources/LocatorsFile.spec"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
			while ((st = br.readLine()) != null) {
				String data[]=st.split("\\s+",3);
				ArrayList<String> typeAndValue = new ArrayList<String>();
				typeAndValue.add(data[1]);
				typeAndValue.add(data[2]);
				pageObjects.put(data[0], typeAndValue);
			}  
		}
		catch(IOException exp) {
			System.out.println("Not able to read the spec file");
		}
		return pageObjects;
	}

	public static List<String> getElement(String elementName){
		Map<String, List<String>> pageObjects=readSpecFile();
		return pageObjects.get(elementName);
	}

}
