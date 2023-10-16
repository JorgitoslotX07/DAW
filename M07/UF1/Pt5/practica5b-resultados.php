<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica5b.php</title> 
    </head> 
    <body>
        <h1>Conversion Euro / Pesetas</h1>

        <?php
            if (is_numeric($_POST["euros"])) {
                $euros = $_POST["euros"];
                $moneda = $_POST["moneda"];
                $result = 0;
                if ($moneda == "dolar") {
                    $result = $euros * 1.325;
                }
                elseif ($moneda == "lliures") {
                    $result = $euros * 0.927;
                }
                elseif ($moneda == "iens") {
                    $result = $euros * 118.232;
                }
                elseif ($moneda == "francs") {
                    $result = $euros * 1.515;
                }

                echo "{$euros} euros equivalen a {$result} {$moneda}";
            }
            else {
                echo "<p>Debe introducir una contidad</p>";
            }

            echo "<p>( <a href='practica5b.php'>Volver al inicio</a> )</p>";
        ?>       
    </body> 
</html> 