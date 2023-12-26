<%@ page import="Models.Compte" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage Compte</title>
<jsp:useBean id='BeanC' class='Models.Compte' scope='request'/>
</head>
<body>
	<h2>Information Compte</h2>
	<%
		Compte c =(Compte)request.getAttribute("BeanC");
	%>
	Numero : <%=c.getNumcpt() %><br>
	Type : <%=c.getTypcpt() %><br>
	Proprietaire : <%=c.getProprietaire() %><br>
	Solde : <%=c.getSolde()%>
</body>
</html>