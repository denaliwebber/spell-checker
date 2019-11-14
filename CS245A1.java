import java.io.*;
import java.net.*;
import java.util.Properties;
import java.util.Scanner;

public class CS245A1
{
	public static void main(String [] args) throws IOException
	{
		String inputFile = args[0];
		String outputFile = args[1];
		String type = "trie";
		Trees dictionary;
		String line;

		System.out.println("Reading in configuration file...");
		Properties prop = new Properties();
		String fileName = "a1properties.txt";
		
		InputStream is = CS245A1.class.getClassLoader().getResourceAsStream(fileName);

		if (is != null)
		{
			prop.load(is);
			type = prop.getProperty("storage");
		}

		if (type.equals("tree"))
		{
			dictionary = new Tree();
		}

		else
		{
			dictionary = new Trie();
		}

		try
		{
    		URL url = new URL("https://raw.githubusercontent.com/magsilva/jazzy/master/resource/dict/english.0");
        	Scanner scan_dict = new Scanner(url.openStream()); 
        	while (scan_dict.hasNextLine())
			{
    			line = scan_dict.nextLine();
    			if (!line.equals(""))
    			{
    				dictionary.insert(line.toLowerCase());
    			}
    		}
    	}

    	catch(IOException e)
    	{
        	e.printStackTrace(); 
    	}

    	Scanner scan_input = new Scanner(new File(inputFile));
    	PrintStream o = new PrintStream(outputFile);
    	PrintStream console = System.out;
    	System.setOut(o);
    	
    	while(scan_input.hasNextLine())
    	{
    		line = scan_input.nextLine();
    		System.out.println(dictionary.find(line.toLowerCase()));
    	}
    }
}
