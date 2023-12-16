<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Chambres</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
             text-align: center;
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
    <h1>Liste des Chambres</h1>
    
    <c:if test="${not empty param.idHotel}">
        <p>Hotel choisi : Titre du hotel - ${param.idHotel}</p>
    </c:if>
    
    <a href="AvantAjouterchambre">Ajouter une chambre</a>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Titre</th>
                <th>Nbre_Lits</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="chambre" items="${lc}">
                <tr>
                    <td>${chambre.idc}</td>
                    <td>${chambre.titre}</td>
                    <td>${chambre.nblits}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
