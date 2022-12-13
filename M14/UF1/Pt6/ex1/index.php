<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 1</title>
    </head>
    <body>
        <h1>Ex 1</h1>
        <?php
        $numero = array();
        $quadrat = array();
        $cub = array();
        for($i = 0; $i < 20; $i++){
            array_push($numero, rand(0,100));
            array_push($quadrat, $numero[$i] * 2);
            array_push($cub, $numero[$i] * 3);
        }
        ?>
        <table>
        <?php
        for($i = 0; $i < 20; $i++){
            echo "<tr><td>" . $numero[$i] . "</td>" . "<td>" .  $quadrat[$i] . "</td>" . "<td>" . $cub[$i]  . "</td></tr>";
        }
        ?>
        </table>
    </body>
</html>