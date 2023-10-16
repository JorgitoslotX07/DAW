<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>exercici5.php</title> 
    </head> 
    <body>
        <?php
            $notesAlumnes = [ 
                "Oscar" => 5.5, 
                "Pepe" => 4.0, 
                "Juan" => 7.5,
                "Nico" => 3.5, 
                "Fede" => 9.0, 
                "Xavier" => 6.5, 
                "David" => 6.9
            ];
            echo quialificacio('Fede', $notesAlumnes) .
            '<br><br>-----------------<br><br>';

            ordenadoPorNotas($notesAlumnes);
            echo '<br><br>';
            ordenadoPorNotas($notesAlumnes, 'asc');
            echo '<br><br>-----------------<br><br>';

            ordenadoAlf($notesAlumnes);
            echo '<br><br>';
            ordenadoAlf($notesAlumnes, 'asc');



            function quialificacio($alumno, $notas) {
                $nota = $notas[$alumno];

                if ($nota < 5) {
                    return "Insuficient";
                }
                else if ($nota == 5 || $nota < 6) {
                    return "Suficient";
                }
                else if ($nota == 6 || $nota < 7) {
                    return "Aprovat";
                }
                else if ($nota == 7 || $nota < 9) {
                    return "Notable";
                }
                else if ($nota == 9 || $nota <= 10) {
                    return "Excel·lent";
                }
                else {
                    return "L'Alumne no existeix";
                }
            }

            function ordenadoPorNotas($notas, $asc_desc = "desc") {
                if ($asc_desc == "asc") {
                    asort($notas);
                    foreach ($notas as $alumno => $nota) {
                        echo "$alumno: $nota <br>";
                    }
                }
                else {
                    arsort($notas);
                    foreach ($notas as $alumno => $nota) {
                        echo "$alumno: $nota <br>";
                    }
                }
            }

            function ordenadoAlf($notas, $asc_desc = "desc") {
                if ($asc_desc == "asc") {
                    ksort($notas);
                    foreach ($notas as $alumno => $nota) {
                        echo "$alumno: $nota <br>";
                    }
                }
                else {
                    krsort($notas);
                    foreach ($notas as $alumno => $nota) {
                        echo "$alumno: $nota <br>";
                    }
                }
            }
        ?>
    </body> 
</html> 