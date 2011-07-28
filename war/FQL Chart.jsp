<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.aoc.readlog.ReadLogfile"%>
<%@page import="java.util.ArrayList,java.util.List,com.aoc.readlog.*,com.aoc.process.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Charts</title>
<SCRIPT LANGUAGE="Javascript" SRC="FusionCharts.js"></SCRIPT>
</head>
<body>

<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr> <h4>Statistical details about Fast Server call on various functionalities of OneSearch Application:</h4>
    <td valign="top" class="text" align="center"> <div id="chartdiv" align="center"> 
        FusionCharts. </div>
      <script type="text/javascript">
		   var chart = new FusionCharts("fusioncharts/FCF_StackedColumn3D.swf", "ChartId", "600", "350");
		   chart.setDataURL("Logs_Data/StCol3D.xml");		   
		   chart.render("chartdiv");
		</script> </td>
  </tr>
------------------------------------------------

					
  <tr>
    <td valign="top" class="text" align="center">&nbsp;</td>
  </tr>
 </table>
<h4>Time taken while retrieving FQL result:</h4>
		<%
			/*In this example, we plot a multi series chart from data contained
			in an array. The array will have three columns - first one for data label (product)
			and the next two for data values. The first data value column would store sales information
			for current year and the second one for previous year.
			
			*/
			        new ProcessLogfile("C:/AOCLogs/Search/FQLlog.xml","C:/AOCLogs/Search/processedFQLlog.xml");
					ReadLogfile rd=new ReadLogfile();
					List finalarrData =rd.getLogData("C:/AOCLogs/Search/processedFQLlog.xml","C:/AOCLogs/Search/processedFQLlog.xml");
						
					String strXML = "<graph caption='Impact of Patch on App Performance' numberSuffix='ms' formatNumberScale='0' decimalPrecision='0' >";
			    	
			    	//Initialize <categories> element - necessary to generate a multi-series chart
			    	String strCategories = "<categories>";
			    	
			    	//Initiate <dataset> elements
			    	String strDataCurr = "<dataset seriesName='After Commit' color='AFD8F8'>";
			    	String strDataPrev = "<dataset seriesName='Before Commit' color='F6BD0F'>";
			    	String[][]arrData1=(String [][])finalarrData.get(0);
			    	String[][]arrData2=(String [][])finalarrData.get(1);
			    	//Iterate through the data	
			    	for(int i2=0;i2<arrData1.length;i2++){
			    		//Append <category name='...' /> to strCategories
			    		strCategories = strCategories + "<category name='" + arrData1[i2][0] + "' />";
			    		//Add <set value='...' /> to both the datasets
			    		//strDataCurr = strDataCurr + "<set value='" + arrData1[i][1] + "' />";
			    		strDataPrev = strDataPrev + "<set value='" + arrData1[i2][1] + "' />";	
			    	}
			    	for(int i1=0;i1<arrData2.length;i1++){
			    		//Append <category name='...' /> to strCategories
			    		//strCategories = strCategories + "<category name='" + arrData2[i][0] + "' />";
			    		//Add <set value='...' /> to both the datasets
			    		 strDataCurr = strDataCurr + "<set value='" + arrData2[i1][1] + "' />";
			    		//strDataPrev = strDataPrev + "<set value='" + arrData[i][2] + "' />";	
			    	}
			    	//Close <categories> element
			    	strCategories = strCategories + "</categories>";
			    	
			    	//Close <dataset> elements
			    	strDataCurr = strDataCurr + "</dataset>";
			    	strDataPrev = strDataPrev + "</dataset>";
			    	
			    	//Assemble the entire XML now
				    		strXML = strXML + strCategories + strDataPrev + strDataCurr +"</graph>";
			
					//Create the chart - MS Column 3D Chart with data contained in strXML
		%>
					<jsp:include page="FusionChartsRenderer.jsp" flush="true"> 
						<jsp:param name="chartSWF" value="fusioncharts/FCF_MSColumn3D.swf" /> 
						<jsp:param name="strURL" value="" /> 
						<jsp:param name="strXML" value="<%=strXML %>" /> 
						<jsp:param name="chartId" value="productSales" /> 
						<jsp:param name="chartWidth" value="600" /> 
						<jsp:param name="chartHeight" value="300" /> 
						<jsp:param name="debugMode" value="false" /> 	
						<jsp:param name="registerWithJS" value="false" /> 						
					</jsp:include>
		<BR>	
		
</body>
</html>