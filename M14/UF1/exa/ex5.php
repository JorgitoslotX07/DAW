<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 1</title>
    </head>
    <body>
        <h1>Ex 1</h1>
        <?php
            if (isset($_POST["numero1"]) and isset($_POST["numero2"]) and isset($_POST["numero3"])) {
                $numero = array();
                array_push($numero, $_POST["numero1"], $_POST["numero2"], $_POST["numero3"]);
                sort($numero);
                echo "<ul>";
                for ($i = 0 ; $i < 3 ; $i++) {
                    echo "<li>" . $numero[$i] . "</li>";  
                }
                echo "</ul>";
            }
            else {
        ?>
                <p>Inseta 3 numeros</p>
                <form action="ex5.php" method="POST">
                    <label for="numero">Numero 1: </label>
                    <input type="number" id="numero1" name="numero1"><br>
                    <label for="numero">Numero 2: </label>
                    <input type="number" id="numero2" name="numero2"><br>
                    <label for="numero">Numero 3: </label>
                    <input type="number" id="numero3" name="numero3"><br>
                    <input type="submit">
                </form>
        <?php
            }
        ?>
    </body>
</html>
