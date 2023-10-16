<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>switch.php</title> 
    </head> 
    <body>
        <table>
            <?php 
                $nom = 'Toni';
                $curs = 'DAW2';
                echo $nom . ' --> ';
                switch ($curs) {
                    case 'DAW1':
                        echo 'Alumne de Web de primer';
                        break;
                    case 'DAW2':
                        echo 'Alumne de Web de segon';
                        break;
                    case 'DAM2':
                        echo 'Alumne de Multiplataforma de segon';
                        break;
                    case 'ASIX1':
                        echo 'Alumne de sistemes de primer';
                        break;
                    case 'ASIX2':
                        echo 'Alumne de sistemes de segon';
                        break;
                    default:
                        echo 'Curs default';
                        break;
                }
            ?>
        </table>
    </body> 
</html> 