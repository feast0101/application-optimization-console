<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final Analysis: Usage Log Chart</title>
<script language="JavaScript" src="FusionCharts.js"></script>
</head>
<body>
<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
 

  <tr>  
    <td class="text" align="top">  <h4>Usage Stats:</h4>
      <div id="chartdiv1" align="center"> 
        FusionCharts. </div>
      <script type="text/javascript">
		   var chart1 = new FusionCharts("fusioncharts/FCF_MSArea2D.swf", "ChartId", "600", "350");
		   chart1.setDataURL("Logs_Data/MSArea2D.xml");		   
		   chart1.render("chartdiv1");
		</script> </td>
</tr>
<tr>

    <td class="text" align="below">  <h4>Usage Pie:</h4>
       <div id="chartdiv2" align="center"> 
        Loading..... </div>
      <script type="text/javascript">
		   var chart2 = new FusionCharts("fusioncharts/FCF_Pie2D.swf", "ChartId", "500", "369");
		   chart2.setDataURL("Logs_Data/Pie2D.xml");		   
		   chart2.render("chartdiv2");
		</script> </td>


 </tr>
</table>
</body>
</html>