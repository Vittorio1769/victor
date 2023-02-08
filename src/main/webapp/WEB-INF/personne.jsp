<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de personnes</title>
</head>
<body>
	<h1>Gestion de personnes</h1>
	<h2>Ajouter une nouvelle personne</h2>
	<form action="personne" method="post">
		<div>
			<label for=nom> Nom : </label> <input type=text name=nom id=nom>
		</div>
		<div>
			<label for=prenom> Prénom : </label> <input type=text name=prenom
				id=prenom>
		</div>
		<button>Enregistrer</button>
	</form>
	<h2>Liste de personnes</h2>
	<ul>
		<c:forEach items="${ personnes }" var="elt">
			<li>${ elt.prenom }--${ elt.nom }--
			   <a href="supprimerPersonne?num=${ elt.num }">supprimer</a>
			   <a href="modifierPersonne?num=${ elt.num }">modifier</a>
			</li>

		</c:forEach>
	</ul>
</body>
</html>