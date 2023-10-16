<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>exercici2.php</title> 
    </head> 
    <body>
        <table>
            <?php 
                $EU = array(
                    "Italy"=>"Rome",
                    "Luxembourg"=>"Luxembourg",
                    "Belgium"=> "Brussels",
                    "Denmark"=>"Copenhagen",
                    "Finland"=>"Helsinki",
                    "France" => "Paris",
                    "Slovakia"=>"Bratislava",
                    "Slovenia"=>"Ljubljana",
                    "Germany" => "Berlin",
                    "Greece" => "Athens",
                    "Ireland"=>"Dublin",
                    "Netherlands"=>"Amsterdam"
                );
                foreach ($EU as $key => $value) {
                    echo "
                        <tr><td>$key</td>
                        <td>$value</td></tr>
                    ";
                }
            ?>
        </table>
    </body> 
</html> 