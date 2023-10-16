<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica5b.php</title> 
    </head> 
    <body>
        <h1>Conversion de monedas</h1>

        <form method="post" action="practica5b-resultados.php">
            <label for="euros">Cantidad en euros:</label>
            <input type="text" name="euros" id="euros">
            <label for="moneda">Convertir a:</label>
            <select name="moneda" id="moneda">
                <option value="dolar">Dòlars USA</option>
                <option value="lliures">Lliures Esterlines</option>
                <option value="iens">Iens Japonesos</option>
                <option value="francs">Francs Suïssos</option>
            </select>
            <br>
            <input type="submit" value="Convertir">
        </form>
    </body> 
</html> 