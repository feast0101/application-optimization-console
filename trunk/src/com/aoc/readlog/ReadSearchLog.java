	package com.aoc.readlog;

	import com.aoc.analyze.*;
	import java.io.File;
	import java.util.Collection;
	import java.util.Iterator;
	import javax.xml.parsers.SAXParser;
	import javax.xml.parsers.SAXParserFactory;
	import org.xml.sax.Attributes;
	import org.xml.sax.SAXException;
	import org.xml.sax.SAXParseException;
	import org.xml.sax.helpers.DefaultHandler;


	/**
	 * This class helps in reading log files saved in xml format<br>
	 * It also help in retrieving all the critical data from the raw xml data<BR>
	 * 
	 * @since 19th July 2011
	 */
	public class ReadSearchLog
	{

		private int[] values;
		private int advancedCount = 0;
		private int basicCount = 0;
		private int commandlineCount = 0;
		private int ObitsCount = 0;
		private int figtablesCount = 0;
		private String[] searchlist;

		public ReadSearchLog(String[] searches) {
			values = new int[searches.length];
			searchlist = searches;
		}

		public int[] getLogData(String fileloc) {
			SAXParserFactory factory = SAXParserFactory.newInstance();

			SaxHandler handler = new SaxHandler();
			File file = new File(fileloc);
			if (file.exists()) {
				try {
					SAXParser parser = factory.newSAXParser();
					parser.parse(file, handler);

					// values={basicCount,advancedCount,figtablesCount,commandlineCount,ObitsCount};
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*
			 * values[0]=basicCount; values[1]=advancedCount; values[2]=figtablesCount; values[3]=commandlineCount;
			 * values[4]=ObitsCount;
			 */
			/*
			 * for(String sName:searchlist){ switch (sName){ case '\t': } }
			 */
			values[0] = figtablesCount;
			values[1] = basicCount;
			values[2] = ObitsCount;
			values[3] = commandlineCount;
			values[4] = advancedCount;
			for (int value : values) {
				System.out.println("value>>>>>>>" + value);
			}
			return values;

		}

		public class SaxHandler extends DefaultHandler
		{

			boolean flag = false;

			public void startElement(String uri, String localName, String qName, Attributes attrs)
					throws SAXParseException, SAXException
			{
				if (qName.equalsIgnoreCase("log4j:message"))
					flag = true;
			}

			public void characters(char ch[], int start, int length) throws SAXException {

				System.out.print("Characters:    \"");

				/*
				 * for (int i = start; i < start + length; i++) { switch (ch[i]) {
				 * 
				 * case '\\': System.out.print("\\\\"); break; case '"': System.out.print("\\\""); break; case '\n':
				 * System.out.print("\\n"); break; case '\r': System.out.print("\\r"); break; case '\t':
				 * System.out.print("\\t"); break; default: System.out.print(ch[i]); break; } }
				 * System.out.print("\"\n");
				 */

				if (flag) {
					String st = new String(ch, start, length);

					if (st.contains("[queryType=advanced:OS")) {
						advancedCount++;

					}
					if (st.contains("[queryType=basic:OS")) {
						basicCount++;

					}
					if (st.contains("[queryType=commandline:OS")) {
						commandlineCount++;

					}
					if (st.contains("[queryType=figtable:OS")) {
						figtablesCount++;

					}
					if (st.contains("[queryType=obits:OS")) {
						ObitsCount++;

					}
				}

			}
		}

	

	}
