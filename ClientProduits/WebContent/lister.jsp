<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
<h2>Liste des Clients</h2>
<table class="table table-striped">
<thead>
<tr>
	<th>Id</th>
	<th>Nom</th>
	<th>Quantité</th>
	<th>Prix</th>
	<th>Modifier</th>
	<th>Supprimer</th>
</tr>
</thead>
<tbody>
<c:forEach items="${produits}" var="produit">
<tr>
	<td><c:out value="${produit.id}"/> </td>
	<td><c:out value="${produit.nom}"/> </td>
	<td><c:out value="${produit.quantite}"/> </td>
	<td><c:out value="${produit.prix}"/> </td>
	<td><a href="ModifierServlet?id=<c:out value="${produit.id}"/>">Modifier</a> </td>
	<td><a href="SupprimerServlet?id=<c:out value="${produit.id}"/>">Supprimer</a> </td>
</tr>
</c:forEach>
</tbody>


</table>

</body>
</html>