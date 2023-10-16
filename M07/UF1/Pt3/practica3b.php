<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica3b.php</title> 
    </head> 
    <body>
        <h1>Conversion Euro / Pesetas</h1>
        <table>
            <tr>
                <th>Euro</th>
                <th>Pesetas</th>
            </tr>
            <?php 
                $pesetes = 166.386;
                
                for ($i = 1; $i <= 10; $i++) {
                    echo '<tr>' . 
                        '<td>' . $i . ' € </td>' .
                        '<td>' . $i * $pesetes . ' pts </td>' .  
                    '</tr>';
                }
            ?>  
        </table>
    </body> 
</html> 