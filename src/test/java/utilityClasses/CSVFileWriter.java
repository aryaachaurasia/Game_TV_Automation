package utilityClasses;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//simply to write all the data into a CSV file 
public class CSVFileWriter {
	
	public  static void writeAllDataToCSVFile(String filename, String[] header,
			List<ArrayList<String>> records){
		
		try {
		    BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));
		    writer.write(String.join(",", header));
		    writer.newLine();

		    for (List<String> record : records) {
		        writer.write(record.toString().replace("[", "").replace("]", "")
		                .replace(", ", ","));
		        writer.newLine();
		    }
		    writer.close();
		}
		catch(IOException exp) {
			System.out.println("Not able to create File "+ filename);
		}
	}
}
