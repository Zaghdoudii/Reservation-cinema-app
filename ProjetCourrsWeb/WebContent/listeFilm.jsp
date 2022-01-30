<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>

            <html>

            <head>

            <body>



                <h1>Liste des Films</h1>
                <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse"
                    bordercolor="#121212" width="62%" id="AutoNumber1">
                    <tr bgcolor="#0000FF">
                        <td>Idantifiant du film </td>
                        <td>Nom du film </td>
                        <td>Réalisateur</td>
                        <td>Duree</td>
                    </tr>

                    <c:forEach var="f" items="${listefilm}">
                        <tr>
                            <td>
                                <c:out value="${c.idFilm}" />
                            </td>
                            <td>
                                <c:out value="${c.nomFilm}" />
                            </td>
                            <td>
                                <c:out value="${c.duree}" />(min)
                            </td>
                            <td>
                                <c:out value="${c.Réalisateur}" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <br>
                <h1>Ajout d'un FILM</h1>
                <form method="POST" action="controleur">
                
                    ID du film :<input type="number" name="idF"  required="required" />  <br> <br>
                    Nom FILM:<input type="text" name="nomF" size="20" required="required"/> <br> <br>
                    Durée du film (en minutes) : <input type="number" name="dureeF" size="20" required="required" /> <br> <br>
                    Réalisateur : <input type="text" name="realF" size="20" required="required" /> <br><br>
                    
                    <input type="submit" value="ajouter" name="action" />
                    <input type="reset" value="Reset" name="reset" />
                </form>
            </body>

            </html>