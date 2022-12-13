<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ex 5</title>
    </head>
    <body>
        <?php
        if (isset($_GET["numero"])) {
            
            $numero= $_GET["numero"];
            $value= $_GET["value"];
            $lista = array(); 
            if (isset($_GET["lista"])) {
                $lista = explode(',' , $_GET["lista"]); 
            }    
            array_push($lista, $numero); 
            if ($value < 7){
                
                $value++;
                echo "<p>Nª".($value +1) . "</p>";
                ?>
                <form action="index.php" method="GET">
                    <label for="numero">Introduce un numero: </label>
                    <input type="number" id="numero" name="numero"><br>
                    <input type="hidden" id="veces" name="value" value="<?php echo $value;?>">
                    <input type="hidden" id="lista" name="lista" value="<?php echo implode(',' , $lista); ?>">
                </form>
                <?php       
            }  
            else {
                echo "<p>";
                for ($i = 0; $i < 8; $i++){
                    if ($lista[$i] % 2 != 0){
                        echo ' <b style="color:red;">' . $lista[$i] . '</b> ';
                    }
                    else {
                        echo ' <b style="color:green;">' . $lista[$i] . '</b> ';
                    }
                }
                echo "</p>";
            }
        }
        else {    
        ?>
        <p>Nª 1</p>
        <form action="index.php" method="GET">
            <label for="numero">Introduce un numero: </label>
            <input type="number" id="numero" name="numero"><br>
            <input type="hidden" id="veces" name="value" value="0">
        </form>
        <?php 
        } 
        ?>
    </body>
</html>