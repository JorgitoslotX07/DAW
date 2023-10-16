<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica3a.php</title> 
    </head> 
    <body>
        <h1>Conversion Euro / Pesetas</h1>
            <?php 
                $pesetes = 166.386;
                
                for ($i = 1; $i <= 10; $i++) {
                    echo '<p>' . $i . ' €  = ' . $i * $pesetes . ' pts </p>';
                }
            ?>  
    </body> 
</html> 