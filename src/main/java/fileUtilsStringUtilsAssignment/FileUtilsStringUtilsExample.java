package fileUtilsStringUtilsAssignment;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class FileUtilsStringUtilsExample {

	public static void main(String[] args) throws IOException {
		
		HashSet<String> uniqueWords = new HashSet<>();
		File inputFile = new File("./src/main/resources/inputFileUtilsData.csv");
		File outputFile = new File("./src/main/resources/outputFileUtilsData.csv");
		try {
			String fileContents = FileUtils.readFileToString(inputFile, "UTF-8");
			String[] words = StringUtils.split(fileContents.replaceAll("[^a-zA-Z]+", " "), " ");
			for(String word: words)
			{
				uniqueWords.add(StringUtils.upperCase(word));
			}
			String data = "Number of unique words : " + uniqueWords.size();
			System.out.println(uniqueWords.toString());
			System.out.println(data);
			FileUtils.writeStringToFile(outputFile, data, "UTF-8");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
