<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>multiplicarTable.php</title> 
    </head> 
    <body>
        <table>
            <?php 
                $numero = 7;
                
                for ($i = 1; $i <= 10; $i++) {
                    echo '<tr><td> ' . $numero . ' * ' . $i . ' = ' . $numero * $i . ' </td></tr>';
                }
            ?>
        </table>
    </body> 
</html> 