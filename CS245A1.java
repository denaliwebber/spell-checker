import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class CS245A1
{
	public static void main(String [] args) throws IOException
	{
		System.out.println("Reading in configuration file...");
		Properties prop = new Properties();
		String fileName = "a1properties.txt";
		
		InputStream is = CS245A1.class.getClassLoader().getResourceAsStream(fileName);

		if (is != null)
		{
			prop.load(is);
			String type = prop.getProperty("storage");
			if (type.equals("trie"))
				System.out.println("Storage type: "+type);
			else if (type.equals("tree"))
				System.out.println("Storage type: "+type);
			else
				System.out.println("Not a valid storage type. Defaulting to trie data structure.");
		}

		else
		{
			String type = "trie";
			System.out.println("No configuration file...");
			System.out.println("Storage type defaults to trie data structure");
		}

		Scanner cd = new Scanner(System.in);
		String inputFile = cd.next();
		System.out.println("Input file name: "+inputFile);
		Scanner scan = new Scanner(new File("input.txt"));
		String line;
		System.out.println("\nContents of input file:");

		while(scan.hasNextLine())
		{
    		line = scan.nextLine();
    		System.out.println(line);
    	}

	}
}