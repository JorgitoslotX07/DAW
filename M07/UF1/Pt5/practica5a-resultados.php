<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica5a.php</title> 
    </head> 
    <body>
        <h1>Conversion Euro / Pesetas</h1>

        <?php
            if (is_numeric($_POST["euros"])) {
                $euros = $_POST["euros"];
                $pesetas = $euros * 166.386;
                echo "{$euros} euros equivalen a {$pesetas} pesetas";
            }
            else {
                echo "<p>Debe introducir una contidad</p>";
            }

            echo "<p>( <a href='practica5a.php'>Volver al inicio</a> )</p>";
        ?>       
    </body> 
</html> 