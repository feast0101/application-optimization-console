package com.aoc.generatexml;
import com.aoc.utility.FusionChartsHelper;


/**
 * This class helps in generating xml files to be fed in fusion chart file<br>
 * It also help in putting all the critical data in proper xml format<BR>
 * @since 18th July 2011
 */
public class StCol3D {
	FusionChartsHelper FCH=new FusionChartsHelper();
	private StringBuilder strXMLStringBuilder=new StringBuilder();
		public StCol3D(String[] searches){
		this.strXMLStringBuilder.append("<graph xAxisName='Search' yAxisName='No.of FAST call' caption='Statistical details about Fast Server call on various Search functionalities of OneSearch Application' subCaption=''decimalPrecision='0' rotateNames='1' numDivLines='3' numberSuffix='times' showValues='0' formatNumberScale='0'>");
		this.strXMLStringBuilder.append("<categories>");
		for(String search:searches){
			this.strXMLStringBuilder.append("<category name='"+search+"' />");
		}
		this.strXMLStringBuilder.append("</categories>");
	}

	public void setStrXML(int[] values, String seriesName) {
		String color=FCH.getFCColor();
		this.strXMLStringBuilder.append("<dataset seriesName='"+seriesName+"' color='"+color+"' showValues='0'>");
		for(int value:values){
		this.strXMLStringBuilder.append("<set value='"+value+"' />");
		}
		this.strXMLStringBuilder.append("</dataset>");
	}
	public String getStrXML(){
		this.strXMLStringBuilder.append("</graph>");
		return this.strXMLStringBuilder.toString();
	}
}