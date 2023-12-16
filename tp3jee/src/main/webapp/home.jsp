<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Hôtels</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            text-align:center;
        }

        h1 {
            color: #333;
        }

        p {
            color: #777;
        }

        a {
            text-decoration: none;
            color: #0088cc;
            margin-bottom: 15px;
            display: inline-block;
        }

        table {
        width: 50%;
        border-collapse: collapse;
        margin-top: 20px;
        margin-left: auto; /* Ajout de cette ligne pour centrer horizontalement */
        margin-right: auto; /* Ajout de cette ligne pour centrer horizontalement */
             }


        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <h1>Liste des Hôtels</h1>
    <p><a href="AvantAjouterchambre">Ajouter chambre</a></p>
     <p><a href="AjoutHotel">Ajouter Hotel</a></p>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Lieu</th>
                <th>Titre</th>
                
            </tr>
        </thead>
        <tbody>
       <c:if test="${not empty lh}">
           <c:forEach var="hotel" items="${lh}">
            <tr>
            <td>${hotel.idh}</td>
            <td>${hotel.lieu}</td>
            <td>${hotel.titre}</td>
            <td><a href="ListeChambres?id=${hotel.idh}">liste des chambres</a></td>
            
            </tr>
           </c:forEach>
      </c:if>
        </tbody>
    </table>

</body>
</html>
