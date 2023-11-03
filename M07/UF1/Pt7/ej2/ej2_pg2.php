<!DOCTYPE html>
<html lang="en">
    <?php
        session_start();

        if (isset($_POST["usuario"]) && isset($_POST["contra"])) {
            $contra = hash('sha512' , $_POST["contra"]);
            
            if ($_SESSION["usuario"][$_POST["usuario"]] == $contra) {
                echo "<p>Usuario y contraseña correcta</p>";
            }
            else {
                echo "<p>Usuario o contraseña incorrecta</p>";
            }

            //header('Location: ej2_pg2.php');
        }
    ?>

    <head> 
        <meta charset="UTF-8">
        <title>ej2_pg2.php</title> 
    </head> 
    <body>
        
        <form method="post" action="ej2_pg2.php">
            
            <label for="usuario">Usuario: </label>
            <input type="text" id="usuario" name="usuario">
            <br>

            <label for="contra">Contraseña: </label>
            <input type="text" id="contra" name="contra">
            <br>

            <input type="submit" value="  Enviar  " name="enviar"> 
        
        </form>

        <br>

        <a href="ej2_pg1.php">
            <button id="volver">Volver</button>
        </a>

    </body> 
</html> 