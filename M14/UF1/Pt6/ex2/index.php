<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex 2</title>
</head>
<body>
    <h1>Ex 2</h1>
    <?php
   
    if (isset($_GET["numero"])) {
        $numero= $_GET["numero"];
        $value= $_GET["value"];
        $lista = array();
        if (isset($_GET["lista_rec0"])) {
            
            for ($i = 0 ; $i <= $value; $i++) {
                $lista_rec = $_GET["lista_rec$i"];
                array_push($lista,$lista_rec);
            }
        }        
        array_push($lista, $numero);      
        if ($value < 9){
            $value++;
            echo "<p>Nª".($value +1) . "</p>";
            ?>
        <form action="index.php" method="get">
            <label for="numero">Introduce un numero: </label>
            <input type="number" id="numero" name="numero"><br>
            <input type="hidden" id="veces" name="value" value="<?php echo $value;?>">
            <?php
                for ($i = 0 ; $i <= $value ; $i++) {
            ?>
            <input type="hidden" id="lista" name="lista_rec<?php echo $i;?>" value="<?php echo $lista[$i];?>">
            <?php
              }
                if (isset($_GET["max"])){
                    $max = $_GET['max'];
                    $min = $_GET['min'];
                }
                else {
                    $max = -INF;
                    $min = INF;
                }

                if ($numero < $min) {
                    $min = $numero;
                }
                elseif ($numero > $max) {
                    $max = $numero;
                }
            ?>
            <input type="hidden" id="max" name="max" value="<?php echo $max;?>">
            <input type="hidden" id="min" name="min" value="<?php echo $min;?>">
        </form>
        <?php
            
        }   
        else {
            ?>
        <table>
        <?php
        $max = $_GET['max'];
        $min = $_GET['min'];
        if ($numero < $min) {
            $min = $numero;
        }
        elseif ($numero > $max) {
            $max = $numero;
        }
        
        for($i = 0; $i <= 10; $i++){
            echo "<tr><td>" . $lista[$i] . "</td>";
            if ($lista[$i] == $max) {
                echo "<td>Maximo</td></tr>";
            }
            elseif ($lista[$i] == $min) {
                echo "<td>Minimo</td></tr>";
            }
            else {
                echo "</tr>";
            }
        }
        ?>
        </table>
        <?php
        }
    }
    else {
        
    ?>
    <p>Nª 1</p>
    <form action="index.php" method="get">
        <label for="numero">Introduce un numero: </label>
        <input type="number" id="numero" name="numero"><br>
        <input type="hidden" id="veces" name="value" value="0">
    </form>
    <?php 
    }
    
    ?>

</body>
</html>
