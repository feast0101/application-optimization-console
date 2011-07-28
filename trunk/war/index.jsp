<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AOC Home Page</title>
</head>
<body>
<table width="100%" height="80%" border="1" align="center" bgcolor="lightblue">
<tr>

<td colspan="2">
<jsp:include page="Header.jsp"></jsp:include>
</td>

</tr>

<tr>

<td width="15%"><jsp:include page="LeftMenu.jsp"></jsp:include></td>
<td>
<iframe id="chart" src="FQL Chart.jsp" width="85%" height="900" frameborder="0">
  <p>Your browser does not support iframes.</p>
</iframe>
</td>

</tr>

<tr>

<td colspan="2"><jsp:include page="Footer.jsp"></jsp:include></td>

</tr>


</table>

</body>
</html>