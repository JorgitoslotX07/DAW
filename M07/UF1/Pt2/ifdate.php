<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>ifdate.php</title> 
    </head> 
    <body>
        <table>
            <?php 
                $dia = intval(date('d'));

                if ($dia > 25) {
                    echo 'Final de mes';
                } 
                else {
                    echo 'Mediado de mes';
                }
            ?>
        </table>
    </body> 
</html> 