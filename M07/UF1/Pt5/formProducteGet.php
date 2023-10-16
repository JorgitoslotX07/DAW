<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <title>formProducteGet.php</title>
</head>
<body>
    <h1>Formulari de Producte</h1>
    <form action="recollidaProducteGet.php" method="get">
        <label for="nom_producte">Nom del producte:</label>
        <input type="text" name="nom_producte" required><br>

        <label for="marca">Marca:</label>
        <select name="marca">
            <option value="Marca1">Marca 1</option>
            <option value="Marca2">Marca 2</option>
            <option value="Marca3">Marca 3</option>
        </select><br>

        <label for="preu_sense_iva">Preu sense IVA:</label>
        <input type="number" name="preu_sense_iva" required><br>

        <label for="tipus_iva">Tipus d'IVA:</label>
        <select name="tipus_iva">
            <option value="0.04">4%</option>
            <option value="0.08">8%</option>
            <option value="0.21">21%</option>
        </select><br>

        <label for="disponibilitat">Disponibilitat:</label>
        <input type="number" name="disponibilitat" required><br>

        <input type="submit" value="Enviar">
    </form>
</body>
</html>
