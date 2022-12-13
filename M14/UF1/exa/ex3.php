<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Ex 3</title>
    </head>
    <body>
        <h1>Ex 3</h1>
        <?php
            echo "<ul>";
            for ($i = 300 ; $i <= 400 ; $i++) {
                if ($i % 3 == 0) {
                    echo "<li>" . $i . "</li>";
                }
            }
            echo "</ul>";
        ?>
    </body>
</html>