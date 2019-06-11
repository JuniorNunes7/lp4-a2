<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
    <title>Cadastro de Geladeiras</title>
</head>

<body>
    <h2>Cadastro de Geladeiras</h2>
    <form method="post" action="/lp4-a2/geladeira">
        Digite o modelo: <br>
        <input type="text" name="modelo"> <br><br>

        Digite o volume: <br>
        <input type="text" name="volume"> <br><br>

        Digite a quantidade de portas: <br>
        <input type="text" name="numPortas"> <br><br>

        Faz gelo? <br>
        <input type="radio" id="sim" name="fazGelo" value="true">
        <label for="sim">Sim</label>

        <input type="radio" id="nao" name="fazGelo" value="false">
        <label for="nao">Não</label>
        
        <br><br><br><br>

        <input type="submit" value="Enviar" onclick="return confirm('Tem certeza que deseja cadastrar essa geladeira?')">
        <input type="reset" value="Cancelar">
    </form>
    
    <a href="/lp4-a2/geladeira">Mostrar Geladeiras</a>
</body>
</html>