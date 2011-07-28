package com.aoc.readlog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This class helps in reading log files saved in xml format<br>
 * It also help in retrieving all the critical data from the raw xml data<BR>
 * @since 20th June 2011
 */
public class ReadLogfile {
	static List finalarrData=new ArrayList();
	static String[][] arrData=new String[9][9];
	static String[][] arrData1=new String[9][9];
	static int i=0;
	static int j=0;
	static int k=0;
	static int i1=0;
	static int j1=0;
	static int k1=0;
	
	public List<String[][]> getLogData(String beforefileloc,String afterfileloc){
		System.out.println("<<<<Inside read attribute gwt log data()>>>>");
		//Store Name of Products
/*		arrData[0][0] = "BasicSearch";
    	arrData[1][0] = "AdvancedSearch";
    	arrData[2][0] = "AlertCreation";
    	arrData[3][0] = "SavedSearch";
    	arrData[4][0] = "TopicBrowse";
    	arrData[5][0] = "Theausurus";*/
    	
    	

		try {
	
			File beforefile = new File(beforefileloc);
			File afterfile = new File(afterfileloc);
			if (beforefile.exists()&& afterfile.exists()){
				//SAX-implementation:
				SAXParserFactory factory = SAXParserFactory.newInstance();
				// Create SAX-parser
				SAXParser parser = factory.newSAXParser();
				//Define a handler
				SaxHandler beforehandler = new SaxHandler();
				SaxHandler2 afterhandler = new SaxHandler2();
				// Parse the xml document
				parser.parse(beforefile, beforehandler);
				parser.parse(afterfile, afterhandler);
			}
			else{
				System.out.println("File not found!");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finalarrData.add(0,arrData);
		finalarrData.add(1,arrData1);
		return finalarrData;
	}
		
	private static class SaxHandler extends DefaultHandler {
		boolean bfname = false;
		public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXParseException,SAXException {
	/*		int length = attrs.getLength();
			//Each attribute
			for (int i=0; i<length; i++) {
				// Get names and values to each attribute
				String name = attrs.getQName(i);
				System.out.print(name);
                String value = attrs.getValue(i);
				System.out.println("\t"+value);
				if(value.equalsIgnoreCase("com.proquest.apps.corelib.search.impl.fastesp.FastESPSearchEngine_ST")){
					System.out.println("----------------------->>>>");
				}
			}*/
		 
	            if (qName.equalsIgnoreCase("log4j:message")) {
	           bfname = true;
	        }
	 
	 
	     }

	     public void characters(char ch[], int start, int length)
	         throws SAXException {
	    /*	 int i=0;
	    	 arrData= new String[i][j];*/
	         if (bfname) {
	        	
	        	String st=new String(ch, start, length);
	            System.out.println("log 4j message : " + st);
	            
	            if (st.contains("aocPointer:") && st.contains("keyword:")){
	               	String st2=st.substring(st.indexOf("keyword:")+8,st.indexOf(","));
	          	             System.out.println("keyword>>>>>>>>"+st2.trim());    
	            	arrData[k][0] =st2.trim();
	               	k++;
	            }
	            if (st.contains("Total time taken:") && st.contains("ms.")){
	               	String st2=st.substring(st.indexOf("Total time taken:")+17,st.lastIndexOf("ms."));
	         	            
	            	//Integer time= Integer.valueOf(st2.trim());
	            	arrData[i][1] =st2.trim();
	               	i++;
	            	            	
	            	//System.out.println("time"+time.toString());
	            }
	            if (st.contains("Search executed. Found") && st.contains("results.")){
	               	String st2=st.substring(st.indexOf("Search executed. Found")+22,st.lastIndexOf("results."));
	            	                 
	            	arrData[j][2] =st2.trim();
	               	j++;
	            }
	            
	            bfname = false;
	          }
	 
	       
	        }
		
	}
	private static class SaxHandler2 extends DefaultHandler {
		boolean bfname = false;
		public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXParseException,SAXException {
		/*	int length = attrs.getLength();
			//Each attribute
			for (int i=0; i<length; i++) {
				// Get names and values to each attribute
				String name = attrs.getQName(i);
				System.out.print(name);
                String value = attrs.getValue(i);
				System.out.println("\t"+value);
				if(value.equalsIgnoreCase("com.proquest.apps.corelib.search.impl.fastesp.FastESPSearchEngine_ST")){
					System.out.println("----------------------->>>>");
				}
			}
		 */
	            if (qName.equalsIgnoreCase("log4j:message")) {
	           bfname = true;
	        }
	 
	 
	     }

	     public void characters(char ch[], int start, int length)
	         throws SAXException {
	    	/* int i=0;
	    	 arrData= new String[i][j];*/
	         if (bfname) {
	        	
	        	String st=new String(ch, start, length);
	            System.out.println("log 4j message : " + st);
	            
	            if (st.contains("aocPointer:") && st.contains("keyword:")){
	               	String st2=st.substring(st.indexOf("keyword:")+8,st.indexOf(","));
	          	             System.out.println("keyword>>>>>>>>"+st2.trim());    
	            	arrData[k][0] =st2.trim();
	               	k++;
	            }
	            if (st.contains("Total time taken:") && st.contains("ms.")){
	               	String st2=st.substring(st.indexOf("Total time taken:")+17,st.lastIndexOf("ms."));
	            	
	            
	            	//Integer time= Integer.valueOf(st2.trim());
	            	arrData1[i1][1] =st2.trim();
	               	i1++;
	            	            	
	            	//System.out.println("time"+time.toString());
	            }
	            if (st.contains("Search executed. Found") && st.contains("results.")){
	               	String st2=st.substring(st.indexOf("Search executed. Found")+22,st.lastIndexOf("results."));
	            	             
	            	arrData1[j1][2] =st2.trim();
	               	j1++;
	            }
	            
	            bfname = false;
	          }
	 
	       
	        }
		
	}
}