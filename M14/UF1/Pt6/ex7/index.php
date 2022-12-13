<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 7</title>
    </head>
    <body>
        <h1>Ex 7</h1>
        <h2>Desordenados</h2>
        <?php
            $numeros = array();
            echo "<p>";
            for($i = 0; $i < 100; $i++){
                array_push($numeros, rand(0,20));
                echo $numeros[$i] . " ";
            }
            echo "</p>";
        ?>
        <h2>Medio Ordenados</h2>
        <?php
            $ceros = array();
            $pares1 = array();
            $impares1 = array();
            for($i = 0; $i < 100; $i++){
                if ($numeros[$i] == 0) {
                    array_push($ceros, $numeros[$i]);
                }
                elseif ($numeros[$i] % 2 == 0) {
                    array_push($pares1, $numeros[$i]);
                }
                else {
                    array_push($impares1, $numeros[$i]);
                }
            }
            echo '<p><span style="color:blue;">';
            $posi = 0;
            for($i = count($ceros); $i >= 0; $i--){
                echo $ceros[$posi] . " ";
                $posi++;
            }
            echo '</span><span style="color:green;">';
            $posi = 0;
            for($i = count($pares1); $i >= 0; $i--){
                echo $pares1[$posi] . " ";
                $posi++;
            }
            echo '</span><span style="color:red;">';
            $posi = 0;
            for($i = count($impares1); $i >= 0; $i--){
                echo $impares1[$posi] . " ";
                $posi++;
            }
            echo '</span></p>';
        ?>
        <h2>Ordenados</h2>
        <?php
            $pares2 = array();
            $impares2 = array();
            for($i = 0; $i < 100; $i++){
                if ($numeros[$i] % 2 == 0){
                    array_push($pares2, $numeros[$i]);
                }
                else {
                    array_push($impares2, $numeros[$i]);
                }
            }
            sort($pares2);
            sort($impares2);
            echo '<p><span style="color:blue;">';
            $posi = 0;
            $cero = 0;
            for($i = count($pares2); $i >= 0; $i--){
                if ($pares2[$posi] > $cero){
                    echo '</span><span style="color:green;">';
                    $cero = INF;
                }
                echo $pares2[$posi] . " ";
                $posi++;
            }
            echo '</span><span style="color:red;">';
            $posi = 0;
            for($i = count($impares2); $i >= 0; $i--){
                echo $impares2[$posi] . " ";
                $posi++;
            }
            echo '</span></p>';
        ?>
    </body>
</html>
