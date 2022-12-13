<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ecuacion de Primer Grado</title>
    </head>
    <body>
        <h1>Resultado Ecuacion de Primer Grado</h1>
        <?php
        $a = $_GET["a"];
        $b = $_GET["b"];
        $x = 0;
        if ($a == 0) {
            if ($b == 0) {
                echo "<p>" . $a . "x + " . $b . " = 0</p><p>x = x</p><p>(infinidad de soluciones)</p>";
            }
            else {
                echo "<p>" . $a . "x + " . $b . " = 0</p><p>0 + b ≠ 0</p><p>x = x</p><p>(sin soluciones)</p>";
            }
        } 
        else {
            $x = -$b / $a;
            echo "<p>" . $a . "x + " . $b . " = 0</p><p> x = " . $x . "</p>";
        }    
        ?>
    </body>
</html>