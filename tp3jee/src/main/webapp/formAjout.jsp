<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Ajouter une Chambre</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }

         h1 {
        color: #333;
        text-align: center;
         }


        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input, select {
            width: 100%;
            padding: 15px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #0088cc;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #006699;
        }
    </style>
</head>
<body>

    <h1>Ajouter une Chambre</h1>

    <form action="AjouterChambre" method="post">
        <label for="titre">Titre :</label>
        <input type="text" name="titre" required/><br/>

        <label for="nblits">Nbre des lits :</label>
        <input type="number" name="nblits" required/><br/>

        <label for="idHotel">Hôtel :</label>
       <select name="idHotel" required>
    <c:forEach var="hotel" items="${hotels}">
        <option value="${hotel.idh}">${hotel.getTitre()}</option>
    </c:forEach>
      </select><br/>


        <input type="submit" value="Soumettre"/>
    </form>

</body>
</html>
