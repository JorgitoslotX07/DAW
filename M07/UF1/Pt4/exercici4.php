<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>exercici4.php</title> 
    </head> 
    <body>
        <?php 
            $notesActivitats = array(7.5, 4.3, 5.0, 7.7, 8.0, 9.0, 5.5, 4.1, 8.2);
            $notesProves = [4.5, 5.5];

            $mediaActivitats = media($notesActivitats);
            $mediaProves = media($notesProves);

            $notaFianl = 0;

            if ($mediaActivitats > 4) {
                $notaFianl = $notaFianl + ($mediaActivitats * 0.4);
            }

            if ($mediaProves > 4) {
                $notaFianl = $notaFianl + ($mediaProves * 0.6);
            }

            echo "La nota final es: ". round($notaFianl, 2);







            function media($lista) {
                $canti = count($lista);
                $suma = array_sum($lista);
                return $suma / $canti;
            };
        ?>
    </body> 
</html> 