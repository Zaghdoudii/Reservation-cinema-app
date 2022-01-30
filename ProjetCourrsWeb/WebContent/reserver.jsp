<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
           
                    <h1>Formulaire de reservation d'un FILM</h1>
              

                <form method="POST" action="controleurRes">

                    Votre Nom : <input type="text" name="nomclient" size="25" /> <br> <br>
                    Votre numero de telephone : <input type="number" name="numtel" size="25" /> <br> <br>
                    Nom FILM : <select name="film">
                        <option value="">--Please choose an option--</option>
                        <option value="nom1">NOM_FILM_1</option>
                        <option value="nom2">NOM_FILM_2</option>
                        <option value="nom3">NOM_FILM_3</option>
                        <option value="nom4">NOM_FILM_4</option>
                        <option value="nom5">NOM_FILM_5</option>
                        <option value="nom6">NOM_FILM_6</option>
                    </select> <br> <br>
                    Date de projection : <input type="date" name="date_proj" size="25" /> <br> <br>
                    Nombre de places : <input type="number" name="nbrplaces" size="2" /> <br> <br>
                    
                    <input type="submit" value="ajouter" name="action" />
                    <input type="reset" value="Reset" name="reset" />

                </form>



</body>
</html>