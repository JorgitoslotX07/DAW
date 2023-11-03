<!DOCTYPE html>
<html lang="en">
    <?php
        session_start();

        session_destroy();
    ?>
    <head> 
        <meta charset="UTF-8">
        <title>ej1_pg3.php</title> 
    </head> 
    <body>
        
        <p>Usuari desautenticat.</p>

        <a href="ej1_pg3.php">
            <button id="volver">Volver</button>
        </a>
    </body> 
</html>