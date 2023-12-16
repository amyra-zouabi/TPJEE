<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Hôtel</title>
 <style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        text-align: center; /* Centrer horizontalement tous les éléments dans le corps */
    }

    h2 {
        color: #333;
    }

    form {
        max-width: 400px;
        margin: 20px auto; /* Centrer horizontalement le formulaire */
    }

    label {
        display: block;
        margin-bottom: 8px;
        color: #555;
    }

    input {
        width: 100%;
        padding: 8px;
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

    <h2>Ajouter un Hôtel</h2>

 
<form action="AjoutHotel" method="POST" >
        <label for="titre">Titre</label>
        <input type="text" id="titre" name="titre" required><br>

        <label for="lieu">Lieu</label>
        <input type="text" id="lieu" name="lieu" required><br>

        <input type="submit" value="Ajouter Hôtel">
    </form>

</body>
</html>
