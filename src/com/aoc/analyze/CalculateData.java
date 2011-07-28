package com.aoc.analyze;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aoc.generatexml.StCol3D;
import com.aoc.readlog.ProcessLogfile;
import com.aoc.readlog.ReadSearchLog;


/**
 * This class copies original file, appends root node and saves at a designated location <br>
 * <BR>
 * @since 22nd June 2011
 */
public class CalculateData
{ 
	Properties properties =  new Properties();
	private String[] searches;
	private StCol3D data;
	
public String getxml(){
	new ProcessLogfile("C:/AOCLogs/Search/FQLlog.xml","C:/AOCLogs/Search/processedFQLlog.xml");
	StCol3D ft=this.loadConfig();
	ReadSearchLog rsl=new ReadSearchLog(searches);
	int[] values= rsl.getLogData("C:/AOCLogs/Search/processedFQLlog.xml");
	ft.setStrXML(values,"test");
	return ft.getStrXML();
  }

  public StCol3D loadConfig(){ 
	  try {
		properties.load(new FileInputStream("D:/Morningstar on 10.112.222.164/Eclipse/workspace/AOClatest/WebContent/WEB-INF/resource/searches.properties"));
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {

		e.printStackTrace();
	}
	int i=0;
	searches=new String[properties.keySet().size()];
	for (Object key : properties.keySet()) {
		if(i<properties.keySet().size())
		searches[i]=properties.get(key).toString();
		i++;
	
	}
	data=new StCol3D(searches);
	return data;
  }
 /* public static void main(String args[]){
		System.out.println("====xml======>"+new CalculateData().getxml());
	}*/

}

