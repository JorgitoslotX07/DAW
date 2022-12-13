<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Dia semana</title>
    </head>
    <body>
        <h1>Resultado Dia semana</h1>
        <?php
        $x = $_GET["x"];
        if ($x > 0 and $x < 8) {
            switch ($x) {
                case 1:
                    echo "<p>Lunes</p>";
                    break;
                case 2:
                    echo "<p>Martes</p>";
                    break;
                case 3:
                    echo "<p>Miercoles</p>";
                    break;
                case 4: 
                    echo "<p>Jueves</p>";
                    break;
                case 5:
                    echo "<p>Viernes</p>";
                    break;
                case 6:
                    echo "<p>Sabado</p>";
                    break;
                default:
                    echo "<p>Domingo</p>";
                    break;
            }
        } 
        else {
            echo "<p>¡¡ERROR!! No has introduciodo un dia balido</p>";
        }    
        ?>
    </body>
</html>