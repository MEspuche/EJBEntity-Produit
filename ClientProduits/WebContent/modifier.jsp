<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="post" action="ModifierServlet">
<input type="hidden" name="id" value="<c:out value="${produit.id}"/>"/>
<label>Nom du produit :</label> <input type="text" name="nom" value="<c:out value="${produit.nom}"/>"/> <br/>
<label>Quantité : </label><input type="text" name="quantite" value="<c:out value="${produit.quantite}"/>"/> <br/> 
<label>Prix : </label><input type="text" name="prix" value="<c:out value="${produit.prix}"/>"/> <br/> 
<input type="submit" value="modifier" />
</form>

</body>
</html>