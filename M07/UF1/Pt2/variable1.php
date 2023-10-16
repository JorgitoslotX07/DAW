<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>variable1.php</title> 
    </head> 
    <body>
        <h1>Primer exemple de variables</h1> 
        <p> 
            <?php 
                $name = "elteunom"; 
                echo "Hola $name, llarga vida i prosperitat"; 
            ?> 
        </p> 
        <br>
        <p><b>a) Com declarem una variable? </b></p> 
        <p> 
            <?php 
                echo 'Una variable se declara poniendo el símbolo de dolar ‘$’ seguido del nombre de la variable
                ex: $nombre = ‘Toni’;';
            ?> 
        </p> 
        <p><b>b) Son rellevants les majúscules i minúscules en la declaració de les variables? </b></p> 
        <p> 
            <?php 
                echo 'Las variables son relevantes, ya que php es sensible a las mayusculas y minúsculas.';
            ?> 
        </p> 
    </body> 
</html> 