<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Gestion des Etudiants</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h1 {
            font-weight: bold;
        }

        h2 {
            color: #333;
        }

        .container {
            width: 300px;
            margin: 50px auto;
        }

        label {
            display: block;
            margin: 10px 0;
        }

        input {
            width: 100%;
            padding: 8px;
            margin: 5px 0 15px;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Gestion des Etudiants</h1>
        <h2>Entrer votre identité</h2>

        <form action="Verification" methode="GET">
            <label for="username">Utilisateur:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Mot de passe:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Se connecter</button>
        </form>
    </div>


</body>
</html>
