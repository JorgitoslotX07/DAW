<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Salario semanal</title>
    </head>
    <body>
        <h1>Resultado Salario semanal</h1>
        <?php
        $x = $_GET["x"];
        if ($x > 0) {
            if ($x < 41) {
                $salario = $x * 12;
                echo "<p>Su salario esta semana es de: " . $salario . "€</p>";
            }
            else {
                $salario = 40 * 12;
                $salario_extra = ($x - 40) * 16;
                echo "<p>Su salario esta semana es de: " . $salario_extra + $salario . "€</p>";
            }
        } 
        else {
            echo "<p>¡¡ERROR!! No has introduciodo una cantidad de horas validias</p>";
        }    
        ?>
    </body>
</html>