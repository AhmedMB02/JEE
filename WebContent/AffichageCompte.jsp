<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Compte"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Liste des Tous Les Comptes </title>
</head>

<body>
	<h1> Liste de tous les Comptes </h1>
	<%
	// voir les imports ci dessus , modele.Compte et java.util.List et java.util.ArrayList
		List<Compte> l=new ArrayList<Compte>();
		l=(ArrayList)request.getAttribute("lac"); 
		int n=l.size();
	%>
	<table border="1">
		<tr> <th> Numéro C </th><th>Solde Compte</th><th> Propriétaire </th> <th> Categorie </th></tr>
		<%
		for(int i = 0; i < n; i++)
		{
			out.println ("<tr>");
			out.print("<td> " +  l.get(i).getNumcpt()+"</td>");
			out.print("<td> " +  l.get(i).getSolde()+"</td>");
			out.print( "<td> " + l.get(i).getProprietaire()+"</td>");
			out.print( "<td> " + l.get(i).getTypcpt()+"</td>");
			out.println ("</tr>");
		} 	
		%>
	</table>
	<br> Nombre Total de comptes: <%=n %>
	<p><p>
	<a href="index.html"> Retour</a>
</body>

</html>