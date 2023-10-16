<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>exercici1.php</title> 
    </head> 
    <body>
        <table>
            <?php 
                $numero = 9;
                $lista = array();
                
                for ($i = 1; $i <= 10; $i++) {
                    array_push($lista, $numero * $i);
                }
                foreach ($lista as $item) {
                    echo "<tr><td>$item</td></tr>";
                }
                /* print_r($lista); */
            ?>
        </table>
    </body> 
</html> 