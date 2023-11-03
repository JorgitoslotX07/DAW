<!DOCTYPE html>
<html lang="en">
    <?php
        session_start();
    ?>
    <head> 
        <meta charset="UTF-8">
        <title>ej1_pg2.php</title> 
    </head> 
    <body>

        <?php
            if (isset($_SESSION["nomUsuario"])) {
                echo '<p>Hola ' . $_SESSION["nomUsuario"] . '.</p>';
                echo '<p>Ets a la pàgina 2.</p>';
                echo '<a href="ej1_pg1.php">';
                echo '<button id="pag1">Anar a pàgina 1</button>';
                echo '</a>';
            } 
        ?>
            
    </body> 
</html>