<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>break.php</title> 
    </head> 
    <body>
        <p> 
            <?php 
                // En los 2 primeros echo se imprimen de una manera normal
                echo "Hola $name, encantat de conèixe't<br/>"; 
                echo "Gràcies per venir!"; 
                // Mientras que nl2br() imprime <br/> antes de cada línea de string, se inseta con (\r\n, \n\r, \n y \r). 
                echo nl2br("Hola $name, encantat de conèixe't<br/>.\n"); 
                echo "Gràcies per venir!\n"; 
            ?>
        </p>  
    </body> 
</html> 