<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Mediana 3 notas</title>
    </head>
    <body>
        <h1>Resultado Mediana 3 notas</h1>
        <?php
        $x = $_GET["x"];
        $y = $_GET["y"];
        $z = $_GET["z"];
        if ($x > 0 && $y > 0 && $z > 0) {
            $total= ($x + $y + $z) / 3;
            echo "<p>La media de " . $x . ", " . $y . " y " . $z . " es: " . $total . "</p>";
        } 
        else {
            echo "<p>¡¡ERROR!! Todas las notras deben de ser positivas</p>";
        }    
        ?>
    </body>
</html>