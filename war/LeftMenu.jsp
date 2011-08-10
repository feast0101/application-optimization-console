<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LeftMenu</title>
</head>
<body>

<ul>
<li>
<span onclick="document.getElementById('chart').src='FQL Chart.jsp';" >Service Optimization Chart</span><br>
</li>
<li>
<span onclick="document.getElementById('chart').src='Search Chart.jsp';" >Statistical analysis of fast Server call on various Search functionalities of OneSearch Application Chart</span><br>
</li>
<li>
<span onclick="document.getElementById('chart').src='Usage Log Chart.jsp';">Usage Log Chart</span><br>
</li>
<li>
<span onclick="document.getElementById('chart').src='Service Call Chart.jsp';">Service Call Chart</span><br>
</li>
</ul>

</body>
</html>