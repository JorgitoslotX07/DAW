<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica6a.php</title> 
    </head> 
    <body>
        <h1>Conversion de monedas</h1>

        <?php
        if (isset($_REQUEST['enviar'])) {
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

            echo "<p>( <a href='practica6a.php'>Volver al inicio</a> )</p>";
        }
        else {
        ?>       


        <form method="post" action="practica6a.php">
            <label for="euros">Cantidad en euros:</label>
            <input type="text" name="euros" id="euros">
            <label for="moneda">Convertir a:</label>
            <select name="moneda" id="moneda">
                <option value="dolar">Dòlars USA</option>
                <option value="lliures">Lliures Esterlines</option>
                <option value="iens">Iens Japonesos</option>
                <option value="francs">Francs Suïssos</option>
            </select>
            <br>
            <input type="submit" value="Convertir" name="enviar">
        </form>

        <?php 
        }
        ?>
    </body> 
</html> 