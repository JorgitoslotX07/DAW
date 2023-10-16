<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>setmana.php</title> 
    </head> 
    <body>
        <table>
            <?php 
                $numeroRandom = rand(0, 6);

                $diaSemana = array("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo");
                
                echo $diaSemana[$numeroRandom];
            ?>
        </table>
    </body> 
</html> 