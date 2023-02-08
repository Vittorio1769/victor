<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>
</head>
<body>
    <h1>Modifier une personne</h1>
    <form action="modifierPersonne" method="post">
        <div>
            <label for=num> Numéro : </label> <input type=text name=num id=num
                value="${ personne.num }" readonly>
        </div>
        <div>
            <label for=nom> Nom : </label> <input type=text name=nom id=nom
                value="${ personne.nom }">
        </div>
        <div>
            <label for=prenom> Prénom : </label> <input type=text name=prenom
                id=prenom value="${ personne.prenom }">
        </div>
        <button>Enregistrer</button>
    </form>
</body>
</html>