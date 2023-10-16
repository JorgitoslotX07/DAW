<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>ifelserand.php</title> 
    </head> 
    <body>
        <table>
            <?php 
                $num = rand(0, 50);
                if ($num == 42) {
                    echo "Quaranta dos, va dir Pensament Profund amb infinita majestuositat i calma. La Resposta a la Gran Pregunta de la Vida, l'Univers i Tota la Resta.";
                } 
                else if ($num % 3 == 0) {
                    echo 'Super3, fiu...';
                } 
                else {
                    echo "Don't panic!";
                }
            ?>
        </table>
    </body> 
</html> 