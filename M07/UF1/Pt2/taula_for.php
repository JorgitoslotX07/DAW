<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>taula_for.php</title> 
        <style>
            .azul {
               
               background-color: blue;
           }
            .rojo {
               
                background-color: red;
            }
        </style>
    </head> 
    <body>
        <table>
            <tr>
                <th>sinus</th>
                <th>cosinus</th>
            </tr>
            <?php 
                function colo($x) {
                    if ($x < 0) {
                        return 'rojo';

                    } else {
                        return 'azul';
                    }
                }
                
                for ($i = 0.01; $i <= 2; $i = $i + 0.01) {
                    for ($j = 0; $j < 10; $j++) {
                        $sin = sin($i);
                        $con = cos($i);

                        echo "<tr>";
                        echo '<td class="' . colo($sin) . '">' . $sin . "</td>";
                        echo '<td class="' . colo($con) . '">' . $con ."</td>";
                        echo "</tr>";
                    }
                }
            
                
            ?>
        </table>
    </body> 
</html> 