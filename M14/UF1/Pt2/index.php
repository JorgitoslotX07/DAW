<html lang="es">
    <head>
        <title>Practica 2 TJORDA</title>
        <meta charset="utf-8">
        <link href="css/pt2.css" rel="stylesheet" type="text/css">
        <?php
        #Crear bariables para color a lazar del fondo
            $colors = ['#162B3F', '#20CAC2', '#5C9559', '#E7B5DC', '#EE65F2', '#9C9BFE', '#888C71', '#4E1BE2', '#04650E', '#BF6780'];
            $random_color = $colors[array_rand($colors)];
        ?>
    </head>
  
    <body style="background: <?=$random_color;?>">  
        <?php 
        #Tabla de contenido para las bariables del servidor        
            echo "
            <div #table>
                <table>
                    <tr>
                        <th>Nombre Variable</th>
                        <th>Valor</th>
                        <th>Descripción</th>
                    </tr>
                    <tr>
                        <td class='mayori'>SERVER_PORT</td>
                        <td class='mayori'>";
            echo $_SERVER['SERVER_PORT'];
            echo "      </td>
                        <td class='mayori'>Devuelve el puerto en la máquina del servidor que está siendo utilizado por el servidor web para la comunicación.</td>
                    </tr>
                    <tr>
                        <td class='mayori'>DOCUMENT_ROOT</td>
                        <td class='mayori'>";
            echo $_SERVER['DOCUMENT_ROOT'];
            echo "      </td class='mayori'>
                        <td class='mayori'>RAÍZ DEL DOCUMENTO es la ruta donde se almacena la aplicación en el sistema de archivos.</td>
                    </tr>
                    <tr>
                        <td class='mayori'>REMOTE_ADDR</td>
                        <td class='mayori'>";
            echo $_SERVER['REMOTE_ADDR'];
            echo "      </td>
                        <td class='mayori'>Devuelve la dirección IP desde donde el usuario está viendo la página actual.</td>
                    </tr>
                    <tr>
                        <td class='mayori'>SERVER_ADDR</td>
                        <td class='mayori'>";
            echo $_SERVER['SERVER_ADDR'];
            echo "      </td>
                        <td class='mayori'>Devuelve la dirección IP del servidor host.</td>
                    </tr>
                     <tr>
                        <td class='mayori'>SERVER_NAME</td>
                        <td class='mayori'>";
            echo $_SERVER['SERVER_NAME'];
            echo "      </td>
                        <td class='mayori'>Devuelve el nombre del servidor host.</td>
                    </tr>
                     <tr>
                        <td class='mayori'>SERVER_SIGNATURE</td>
                        <td class='mayori'>";
            echo $_SERVER['SERVER_SIGNATURE'];
            echo "      </td>
                        <td class='mayori'>Devuelve la versión del servidor y el nombre de host virtual que se agregan a las páginas generadas por el servidor.</td>
                    </tr>
                    <tr>
                        <td class='mayori'>SERVER_SOFTWARE</td>
                        <td class='mayori'>";
            echo $_SERVER['SERVER_SOFTWARE'];
            echo "      </td>
                        <td class='mayori'>Devuelve la cadena de identificación del servidor.</td>
                    </tr>
                    <tr>
                        <td class='mayori'>PHP_SHELF</td>
                        <td class='mayori'>";
            echo $_SERVER["PHP_SELF"];
            echo "      </td>
                        <td class='mayori'>Devuelve el nombre de archivo del script que se está ejecutando actualmente.</td>
                    </tr>
                    <tr>
                        <td>SCRIPT_NAME</td>
                        <td>";
            echo $_SERVER['SCRIPT_NAME'];
            echo "      </td>
                        <td>Devuelve la ruta del script actual.</td>
                    </tr>
                </table>
            </div>";
	#Introducir imagon + fecha de ejecucion, creacion y autor
            $Fecha_ejecucion = date('d-m-Y h:i:s a', time()); 
            $Fecha_creacion = "30-09-2022";
            $Autor = "Toni Jordà León";
            echo "
                <img src='img/php_logo.png' alt='logo_PHP'>
                <div id='uno'>
                    <p><strong>Fecha de ejecucion:<strong> $Fecha_ejecucion</p>          
                    <p><strong>Fecha de cracion:<strong> $Fecha_creacion</p>           
                    <p><strong>Autor:<strong> $Autor</p>
                </div>
            ";
        ?> 
    </body>
</html>    
