<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Saludo por hora</title>
    </head>
    <body>
        <h1>Resultado Saludo por hora</h1>
        <?php
        $x = $_GET["x"];
        if ($x >= 0 and $x < 24) {
            if ($x > 5 and $x < 13) {
                echo "<p>Bon dia</p>";
            }
            else {
                if ($x > 12 and $x < 21) {
                    echo "<p>Bona tarda</p>";
                }
                else {
                    echo "<p>Bona nit</p>";
                }
            }
        } 
        else {
            echo "<p>¡¡ERROR!! No ha introduciodo una hora balido</p>";
        }    
        ?>
    </body>
</html>