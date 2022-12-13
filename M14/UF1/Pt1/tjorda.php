<html>
    <head>
        <title>PHP Test</title>
        <?php # CSS ;?>
        <style> 
            * {
                background: black;
                font-family: monospace
                color: white;
            }
            p.test {
                color: white;
                font-family: 'Courier New', Courier, monospace;
                text-align: center;
                font-size: 48px;
            }
        </style>
    </head>
    <body>
        <?php 
            $hola = 'Hello';
            $mundo = 'World';
            echo "<p class='test'>$hola $mundo</p>"; 
        ?>

        <br><br>

        <?php
            $Fecha_ejecucion = date('d-m-Y h:i:s a', time());  
            echo "<p><strong>Fecha de ejecucion:<strong> $Fecha_ejecucion</p>";
            
            $Fecha_creacion = "16-09-2022";
            echo "<p><strong>Fecha de cracion:<strong> $Fecha_creacion</p>";

            $Autor = "Toni Jordà León";
            echo "<p><strong>Autor:<strong> $Autor</p>";
        ?> 
    </body>
</html> 
