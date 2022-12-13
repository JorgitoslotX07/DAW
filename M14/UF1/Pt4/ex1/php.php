<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Asignatura primera hora</title>
    </head>
    <body>
        <h1>Resultado Asignatura primera hora</h1>
        <?php
        $x = $_GET["x"];
        if ($x > 0 and $x < 8) {
            switch ($x) {
                case 1:
                    echo "<p>La primera hora es de M04 - Lenguaje de Marcas y Sistemas de Gestion de Informacion</p>";
                    break;
                case 2:
                    echo "<p>La primera hora es de M03 - Programacion</p>";
                    break;
                case 3:
                    echo "<p>La primera hora es de M10 - FOL</p>";
                    break;
                case 4: 
                    echo "<p>La primera hora es de M05 - Entornos de Desarrollo</p>";
                    break;
                case 5:
                    echo "<p>La primera hora es de M11 - EIE</p>";
                    break;
                default:
                    echo "<p>Es fin se semana</p>";
                    break;
            }
        } 
        else {
            echo "<p>¡¡ERROR!! No has introduciodo un numero balido</p>";
        }    
        ?>
    </body>
</html>