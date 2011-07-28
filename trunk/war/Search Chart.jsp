<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.aoc.readlog.ReadLogfile"%>
<%@page
	import="java.util.ArrayList,java.util.List,com.aoc.readlog.*,com.aoc.analyze.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Charts</title>
<SCRIPT LANGUAGE="Javascript" SRC="FusionCharts.js"></SCRIPT>
</head>
<body>

<table width="98%" border="0" cellspacing="0" cellpadding="3"
	align="center">
	<tr>
		<h4>Bar Diagram:</h4>
	</tr>

	<tr>

		<td valign="top" class="text" align="center">
		<div id="chartdiv" align="center">FusionCharts.</div>
		<script type="text/javascript">
		   var chart1 = new FusionCharts("fusioncharts/FCF_StackedColumn3D.swf", "ChartId", "600", "350");
		   chart1.setDataXML("<%=new CalculateData().getxml()%>");		   
		   chart1.render("chartdiv");
		</script></td>
	</tr>

	<tr>
		<td valign="top" class="text" align="center">&nbsp;</td>
	</tr>
</table>


</body>
</html>