<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Suma, Resta, Multiplición y Division</title>
    </head>
    <body>
        <h1>Resultado Suma, Resta, Multiplición y Division</h1>
        <?php
        $x = $_GET["x"];
        $y = $_GET["y"];
        echo "<p>El reultado de " . $x . " + " . $y . " es -->  " . $x + $y . "</p>";
        echo "<p>El reultado de " . $x . " - " . $y . " es -->  " . $x - $y . "</p>";
        echo "<p>El reultado de " . $x . " * " . $y . " es -->  " . $x * $y . "</p>";
        echo "<p>El reultado de " . $x . " / "  . $y . " es -->  " . $x / $y . "</p>";
        ?>
    </body>

</html>