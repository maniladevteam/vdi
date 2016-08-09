<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page import="java.io.File" %>
<%@ page import="java.io.InputStream" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Launch Vm portal</title>
</head>
<body>
	<c:set var="tester" value="sample" />
	<%
	
		String responses;
		try {
	   
	      // Read and print the output
	      String line = null;
	     
			Runtime runtime = Runtime.getRuntime();
				
				runtime.exec("C:/Program Files/VMware/VMware View/Client/bin/wswc.exe vmware-view://view-APAC.ten.thomsonreuters.com/AP006%2D%20%28XP%20EN%202003%20IE%207%29%20Kobra%205.0.0+RTA%205.0?action=start-session&logInAsCurrentUser=true");

		} catch (Exception c) {
			responses = c.getMessage();
			pageContext.setAttribute("responses", responses);
		}
	%>
	<label><c:out value="${responses}" /></label>
</body>
</html>