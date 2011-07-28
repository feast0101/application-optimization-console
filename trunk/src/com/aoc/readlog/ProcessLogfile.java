package com.aoc.readlog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * This class copies original file, appends root node and saves at a designated location <br>
 * ProcessLogfile(String originalfile,String processedfile) is used by various jsp files;<BR>
 * @since 22 th June 2011
 */
public class ProcessLogfile
{    static String[][] arrData;
	/* This class copies original file, appends root node and saves at a designated location */
	public ProcessLogfile(String originalfile,String processedfile) {
		try {
			System.out.println("<<<<Inside ProcessLogfile>>>>");
			
			              BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			                       
			              FileReader input = new FileReader(originalfile);
			              FileWriter output = new FileWriter(processedfile);
			              StringBuffer outputfile=new StringBuffer();
			              outputfile.append("<LogRoot>");
			              /* Filter FileReader through a Buffered read to read a line at a
			                 time */
			              BufferedReader bufRead = new BufferedReader(input);
			              BufferedWriter bufWrite = new BufferedWriter(output);
			              String line;    // String that holds current file line
			              int count = 0;  // Line number of count 
			              
			              // Read first line
			              line = bufRead.readLine();
			             
			              count++;
			              
			              // Read through file one line at time. Print line # and line
			              while (line != null){
			                  System.out.println(count+": "+line);
			                  outputfile.append(line);
			                  line = bufRead.readLine();
			                  count++;
			              }
			              outputfile.append("</LogRoot>");
			              bufWrite.write(outputfile.toString());
			              bufRead.close();
			              bufWrite.close();
			              
			          }catch (ArrayIndexOutOfBoundsException e){
			                  
		}

		catch (Exception e) {}
	}
	public int countFrequency(){
		int i=0;
		
		return i;
	}
	/*public static void main(String args[]){
	
		new ProcessLogfile("C:/Logs/Search/FQLlog.xml","C:/Logs/Search/processedFQLlog.xml");
	}*/

}
