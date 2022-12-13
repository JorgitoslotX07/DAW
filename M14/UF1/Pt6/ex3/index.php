<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex 3</title>
</head>
<body>
    <h1>Ex 3</h1>
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
        if ($value < 14){
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
            ?>
        </form>
        <?php
            
        }  
        else {
       
        $lista2 = array();
        for($i = 0; $i <= 15; $i++){
            if ($i == 0) {
                array_push($lista2, $lista[15]);
            }
            elseif ($i == 2){
                
            }
            else {
                array_push($lista2, $lista[($i - 1)]);
            }
        }
        print_r($lista2);
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
