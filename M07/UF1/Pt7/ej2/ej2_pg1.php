<!DOCTYPE html>
<html lang="en">
    <?php
        session_start();

        if (isset($_POST["usuario"]) && isset($_POST["contra"])) {
            $contra = hash('sha512' , $_POST["contra"]);
            
            if (isset($_SESSION["usuario"])) {
                $_SESSION["usuario"][$_POST["usuario"]] = $contra;

            } else {
                $_SESSION["usuario"] = [
                    $_POST["usuario"] => $contra
                ];            
            }

            header('Location: ej2_pg2.php');
        }
    ?>

    <head> 
        <meta charset="UTF-8">
        <title>ej2_pg1.php</title> 
    </head> 
    <body>
        
        <form method="post" action="ej2_pg1.php">
            
            <label for="usuario">Usuario: </label>
            <input type="text" id="usuario" name="usuario">
            <br>

            <label for="contra">Contraseña: </label>
            <input type="text" id="contra" name="contra">
            <br>

            <input type="submit" value="  Enviar  " name="enviar"> 
        
        </form>

    </body> 
</html> 