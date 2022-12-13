<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 4</title>
    </head>
    <body>
        <h1>Ex 4</h1>
        <?php
            if (isset($_POST["dia"]) and isset($_POST["mes"])) {
                $dia = $_POST["dia"];
                $mes = $_POST["mes"];
                if ($dia < 1 or $dia > 31 or $mes < 1 or $mes > 12) {
        ?>
                    <p>Simbolo horoscopo:</p>
                    <form action="ex4.php" method="POST">
                        <label for="numero">Introduce dia: </label>
                        <input type="number" id="dia" name="dia"><br>
                        <label for="numero">Introduce mes: </label>
                        <input type="number" id="mes" name="mes"><br>
                        <input type="submit">
                    </form>
                    <p style="color: red;"><b>ERROR</b> Dia o Mes incorrectos</p>
        <?php
                }
                else { 
                    switch ($mes) {
                        case 1:
                            if ($dia < 21){
                                echo "<p>CAPRICORNIO</p>";
                            }
                            else {
                                echo "<p>ACUARIO</p>";
                            }
                            break;
                        case 2:
                            if ($dia < 20){
                                echo "<p>ACUARIO</p>";
                            }
                            else {
                                echo "<p>PISIS</p>";
                            }
                            break;
                        case 3:
                            if ($dia < 21){
                                echo "<p>PISIS</p>";
                            }
                            else {
                                echo "<p>ARIES</p>";
                            }
                            break;
                        case 4: 
                            if ($dia < 20){
                                echo "<p>ARIES</p>";
                            }
                            else {
                                echo "<p>TAURO</p>";
                            }
                            break;
                        case 5:
                            if ($dia < 21){
                                echo "<p>TAURO</p>";
                            }
                            else {
                                echo "<p>GEMINIS</p>";
                            }
                            break;
                        case 6:
                            if ($dia < 21){
                                echo "<p>GEMINIS</p>";
                            }
                            else {
                                echo "<p>CANCER</p>";
                            }
                            break;
                        case 7:
                            if ($dia < 23){
                                echo "<p>CANCER</p>";
                            }
                            else {
                                echo "<p>LEO</p>";
                            }
                            break;
                        case 8:
                            if ($dia < 23){
                                echo "<p>LEO</p>";
                            }
                            else {
                                echo "<p>VIRGO</p>";
                            }
                            break;
                        case 9:
                            if ($dia < 23){
                                echo "<p>VIRGO</p>";
                            }
                            else {
                                echo "<p>LIBRA</p>";
                            }
                            break;
                        case 10:
                            if ($dia < 23){
                                echo "<p>LIBRA</p>";
                            }
                            else {
                                echo "<p>ESCORPIO</p>";
                            }
                            break;
                        case 11:
                            if ($dia < 22){
                                echo "<p>ESCORPIO</p>";
                            }
                            else {
                                echo "<p>SAGITARIO</p>";
                            }
                            break;
                        default:
                            if ($dia < 22){
                                echo "<p>SAGITARIO</p>";
                            }
                            else {
                                echo "<p>CAPRICORNIO</p>";
                            }
                            break;
                    }
                }
            }
            else {
        ?>
                <p>Simbolo horoscopo:</p>
                <form action="ex4.php" method="POST">
                    <label for="numero">Introduce dia: </label>
                    <input type="number" id="dia" name="dia"><br>
                    <label for="numero">Introduce mes: </label>
                    <input type="number" id="mes" name="mes"><br>
                    <input type="submit">
                </form>
        <?php
            }
        ?>
    </body>
</html>