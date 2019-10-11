import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg {
	
	String[] sameStations = new String[10];
	char letter;
	int count;
	
	public LetterAvg(char letter)
	{
		this.letter = letter;
		try {
			numberOfStationWithLetterAvg();
		} catch (IOException e) {
			System.out.println("Unable to read file");
			e.printStackTrace();
		}
	}
	
	public int numberOfStationWithLetterAvg() throws IOException
	{
		BufferedReader rd = new BufferedReader(new FileReader("Mesonet.txt"));
		String lineRead = "";
		
		// Skip 3 lines of Mesonet.txt
		lineRead = rd.readLine();
		lineRead = rd.readLine();
		lineRead = rd.readLine();
		
		count=0;
		while(lineRead != null) 
		{
			if (lineRead.charAt(1) == letter) {
				sameStations[count] = lineRead.substring(1,5);
				count++;
			}
			lineRead = rd.readLine();
		}
		rd.close();
		return count;
	}
	
	@Override
	public String toString()
	{
		String result = "\nThey are:";
		for (int i=0; i<count; i++)
		{
			result += String.format("\n%s", sameStations[i]);
		}
		return result;
	}
}
