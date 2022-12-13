<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Factura</title>
    </head>
    <body>
        <h1>Resultado Factura</h1>
        <?php
        $x = $_GET["x"];
        $y = 0.21;
        echo "<p>La pagas es de-->  " . $x * $y . "Є</p>";
        ?>
    </body>

</html>