<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 2</title>
    </head>
    <body>
        <h1>Ex 2</h1>
        <?php
            $pos = array();
            $neg = array();
            for ($i = 0 ; $i < 10 ; $i++) {
                $numeros = rand(-100,20);
                if ($numeros >= 0) {
                    array_push($pos, $numeros);
                }
                else{
                    array_push($neg, $numeros);
                }
            }
            echo "<p>Negatius</p><ul>";
            $ubi = 0;
            for ($n = count($neg) ; $n > 0 ; $n--) {
                echo "<li>" . $neg[$ubi] . "</li>";
                $ubi++;
            }
            echo "</ul><p>Positius</p><ul>";
            $ubi = 0;
            for ($p = count($pos) ; $p > 0 ; $p--) {
                echo "<li>" . $pos[$ubi] . "</li>";
                $ubi++;
            }
            echo "</ul>";
        ?>
    </body>
</html>