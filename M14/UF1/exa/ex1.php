<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 1</title>
    </head>
    <body>
        <h1>Ex 1</h1>
        <?php
            if (isset($_POST["numero"])) {
                $numero = $_POST["numero"];
                echo "<ol>";
                for ($i = 0 ; $i < 100 ; $i++) {
                    echo "<li>" . $numero . "</li>";
                    $numero++;
                }
                echo "</ol>";
            }
            else {
        ?>

                <form action="ex1.php" method="POST">
                    <label for="numero">Introduce un numero: </label>
                    <input type="number" id="numero" name="numero"><br>
                    <input type="submit">
                </form>
        <?php
            }
        ?>
    </body>
</html>