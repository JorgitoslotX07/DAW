<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ex 5</title>
    </head>
    <body>
        <?php
        if (isset($_GET["temp"])) {
            $meses = array('Enero','Febrero' , 'Marzo' , 'Abril' , 'Mayo' , 'Junio' , 'Julio' , 'Agosto' , 'Septiembre' , 'Obtubre' , 'Noviembre' , 'Diciembre');
            $temp= $_GET["temp"];
            $value= $_GET["value"];
            $lista = array(); 
            if (isset($_GET["lista"])) {
                $lista = explode(',' , $_GET["lista"]); 
            }    
            array_push($lista, $temp); 
            if ($value < 11){
                $value++;
                echo "<p>Nª".($value +1) . "</p>";
                ?>
                <form action="index.php" method="GET">
                    <label for="numero">Introduce la temperatura media del mes de <?php echo $meses[$value]; ?>: </label>
                    <input type="number" id="temp" name="temp"><br>
                    <input type="hidden" id="veces" name="value" value="<?php echo $value;?>">
                    <input type="hidden" id="lista" name="lista" value="<?php echo implode(',' , $lista); ?>">
                </form>
                <?php
                
            }  
            else {
                echo "<table>";
                for ($i = 0; $i < 12; $i++){
                    echo "<tr><th>" . $meses[$i]. ":</th><td>";
                    for ($h = $lista[$i]; $h > 0; $h--){
                        echo " {[-]} ";
                    }
                    echo "</td></tr>";
                }
                echo "</table>";
            }
        }
        else {    
        ?>
        <p>Nª 1</p>
        <form action="index.php" method="GET">
            <label for="numero">Introduce la temperatura media del mes de Enero: </label>
            <input type="number" id="temp" name="temp"><br>
            <input type="hidden" id="veces" name="value" value="0">
        </form>
        <?php 
        } 
        ?>
    </body>
</html>
