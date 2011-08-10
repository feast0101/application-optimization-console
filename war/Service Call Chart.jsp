<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final Analysis: Graphical Gantt Chart</title>
<script language="JavaScript" src="FusionCharts.js"></script>
</head>
<body>
<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
 <tr> 
    <td valign="top" class="text" align="top"> <div id="PieChartLoading...." align="center"> 
        FusionCharts. </div>
      <script type="text/javascript">
		   var piechart = new FusionCharts("fusioncharts/FCF_Pie3D.swf", "ChartId", "400", "350");
		   piechart.setDataURL("Logs_Data/Pie3D.xml");		   
		   piechart.render("PieChartLoading....");
		</script> </td>
  </tr>
  <tr> 
    <td valign="top" class="text" align="down"> <div id="ColumnChartLoading...." align="center"> 
        FusionCharts. </div>
      <script type="text/javascript">
		   var chart = new FusionCharts("fusioncharts/FCF_MSColumn3DLineDY.swf", "ChartId", "600", "350");
		   chart.setDataURL("Logs_Data/Col3DLineDY.xml");		   
		   chart.render("ColumnChartLoading....");
		</script> </td>
  </tr>

</table>
</body>
</html>