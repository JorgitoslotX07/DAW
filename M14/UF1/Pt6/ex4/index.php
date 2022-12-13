<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 4</title>
    </head>
    <body>
        <h1>Ex 4</h1>
        <?php
        if (isset($_POST["numero1"]) and isset($_POST["numero2"])) {
            $lista = array();
            $numero1 = $_POST["numero1"];
            $numero2 = $_POST["numero2"];
            for ($i = 0 ; $i < 100; $i++) {
                $lista_rec = $_POST["lista_rec$i"];
                array_push($lista,$lista_rec);
            } 
            ?>  
            <p>
            <?php
            for($i = 0; $i < 100; $i++){
                if ($lista[$i] == $numero1) {
                    echo '<b style="color:red">' . $numero2 . " </b>";
                }
                else {
                    echo $lista[$i] . " ";
                }
            }
            ?>  
            </p>
            <?php
        }
        else {
            $lista = array();
            for($i = 0; $i < 100; $i++){
                array_push($lista, rand(0,20));
            }
            ?>  
            <p>
            <?php
            
            for($i = 0; $i < 100; $i++){
                echo $lista[$i] . " ";
            }
            ?>
            </p>
            <form action="index.php" method="POST">
                <label for="numero1">Introduce un numero: </label>
                <input type="number" id="numero1" name="numero1"><br>
                <label for="numero2">Introduce un numero: </label>
                <input type="number" id="numero2" name="numero2"><br>
                <?php
                    for ($i = 0 ; $i < 100; $i++) {
                ?>
                <input type="hidden" id="lista" name="lista_rec<?php echo $i;?>" value="<?php echo $lista[$i];?>">
                <?php
                }
                ?>
                <input type="submit" id="enviar" name="enviar" value="enviar">
            </form>
        <?php 
        }
        ?>
    </body>
</html>
