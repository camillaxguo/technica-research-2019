import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Compress {
	
	//Saves the compressed version of file as file-comp.txt
public static void compressHelper(String f, String output) throws FileNotFoundException, UnsupportedEncodingException {

    File file = new File(f);
    
    PrintWriter writer;
	try {
		writer = new PrintWriter(output, "UTF-8");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
        	String[] line = sc.nextLine().split(" "); 
            if(line[0].equals("f")) {
            	writer.println("f");
            	while(line[0].equals("f")) {
	            	writer.print(line[1] + " " + line[2] + " " + line[3]);
	            	if(sc.hasNextLine())
	            		line = sc.nextLine().split(" "); 
	            	else break;
            	}
            }
            else if(line[0].equals("vt")) {
            	writer.println("vt");
            	while(line[0].equals("vt")) {
	            	writer.print(line[1] + " " + line[2] + " ");
	            	if(sc.hasNextLine())
	            		line = sc.nextLine().split(" "); 
	            	else break;
            	}
            	writer.println();
            }
            else if(line[0].equals("v")) {
            	String[] line2 = sc.nextLine().split(" ");
            	if(line2[0].equals("ny")) {
            		String[] line3 = sc.nextLine().split(" ");
            		if(line3[0].equals("nv")) {
            			writer.println("v ny nv");
            			writer.print(line[1] + " " + line[2] + " " + line[3]);
            			writer.print(line2[1] + " " + line2[2] + " " + line2[3]);
            			writer.print(line3[1] + " " + line3[2] + " " + line3[3]);
            			while(line[0].equals("v")){
            				line = sc.nextLine().split(" ");
            				line2 = sc.nextLine().split(" ");
            				line3 = sc.nextLine().split(" ");
            				writer.print(line[1] + " " + line[2] + " " + line[3]);
                			writer.print(line2[1] + " " + line2[2] + " " + line2[3]);
                			writer.print(line3[1] + " " + line3[2] + " " + line3[3]);
            			}
            		}
            		else break;
            	}
            	else break;
            }
            else
            	writer.println(line[0] + " " + line[1] + " " + line[2]);
        }
        sc.close();
        writer.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
	
	public static void compress(String infile, String outfile) {
		try {
			compressHelper(infile, "temp.txt");
			System.setIn(new FileInputStream(new File("temp.txt")));
			System.setOut(new PrintStream(new File(outfile)));
			String[] a = {"-"};
			Huffman.main(a);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

}
