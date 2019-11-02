import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class CS245A1
{
	public static void main(String [] args) throws IOException
	{
		String inputFile = args[0];
		String outputFile = args[1];
		String type = "trie";

		System.out.println("Reading in configuration file...");
		Properties prop = new Properties();
		String fileName = "a1properties.txt";
		
		InputStream is = CS245A1.class.getClassLoader().getResourceAsStream(fileName);

		if (is != null)
		{
			prop.load(is);
			type = prop.getProperty("storage");
			if (type.equals("trie"))
			{
				System.out.println("Storage type: "+type);
			}

			else if (type.equals("tree"))
			{
				System.out.println("Storage type: "+type);
			}

			else
			{
				System.out.println("Not a valid storage type. Defaulting to trie data structure.");
			}
		}

		else
		{
			System.out.println("No configuration file...");
			System.out.println("Storage type defaults to trie data structure");
		}

		Scanner scan_dict = new Scanner(new File("english.0"));
		String line;

		PrintStream o = new PrintStream(outputFile);

    	PrintStream console = System.out;

    	System.setOut(o);

		if (type.equals("tree"))
		{
			Tree dictionary = new Tree();

			while(scan_dict.hasNextLine())
			{
    			line = scan_dict.nextLine();
    			if (!line.equals(""))
    			{
    				dictionary.insert(line);
    				dictionary.print();
    				System.out.println(line);
    			}
    		}
		}
    }
}

//to print to file
//System.setOut(o);
//to print to console
//System.setOut(console);