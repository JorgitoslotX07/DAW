<!DOCTYPE html>
<html lang="en">
    <?php
        session_start();

        if (isset($_POST["nomUsuario"])) {
            $_SESSION["nomUsuario"] = $_POST["nomUsuario"];
            header('Location: ej1_pg2.php');
        } 
    ?>

    <head> 
        <meta charset="UTF-8">
        <title>ej1_pg1.php</title> 
    </head> 
    <body>

        <?php
            if (isset($_SESSION["nomUsuario"])) {
                echo '<p>Hola ' . $_SESSION["nomUsuario"] . '.</p>';
                echo '<p>Ets a la pàgina 1.</p>';

                echo '<a href="ej1_pg2.php">';
                echo '<button id="pag2">Anar a pàgina 2</button>';
                echo '</a>';

                echo '<br>';

                echo '<a href="ej1_pg3.php">';
                echo '<button id="salir">Sortir</button>';
                echo '</a>';
            } else {
        ?>       

        <br>
        
        <form method="post" action="ej1_pg1.php">
            
            <label for="nomUsuario">Nombre: </label>
            <br>
            <input type="text" id="nomUsuario" name="nomUsuario">
            <br>
            <input type="submit" value="  Enviar  " name="enviar"> 
        </form>
        <?php
            }
        ?>
    </body> 
</html> 