<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <title>recollidaProducteGet.php</title>
</head>
<body>
    <h1>Recollida de Producte</h1>
    <?php
        $nom_producte = $_GET["nom_producte"];
        $marca = $_GET["marca"];
        $preu_sense_iva = floatval($_GET["preu_sense_iva"]);
        $tipus_iva = floatval($_GET["tipus_iva"]);
        $disponibilitat = intval($_GET["disponibilitat"]);

        $preu_amb_iva = $preu_sense_iva + ($preu_sense_iva * $tipus_iva);

        echo "<p>Nom del producte: $nom_producte</p>";
        echo "<p>Marca: $marca</p>";
        echo "<p>Preu sense IVA: $preu_sense_iva</p>";
        echo "<p>Tipus d'IVA: " . ($tipus_iva * 100) . "%</p>";
        echo "<p>Disponibilitat: $disponibilitat unitats</p>";
        echo "<p>Preu amb IVA: $preu_amb_iva</p>";
    ?>
</body>
</html>
