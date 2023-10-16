<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>exercici3php</title> 
    </head> 
    <body>
        <?php 
            $menjar = array(
                'fruita' => [
                    'A' => 'taronja',
                    'B' => 'plàtan',
                    'C' => 'poma'
                ],
                'peix' => [
                    'mar' => [
                        'bacallà'
                    ],
                    'riu' => [
                        'truita'
                    ]
                ],
                'carn' => [
                    'vadella',
                    'corder',
                    'pollastre'
                ]
            );

            foreach ($menjar as $key => $value) {
                if ($key == 'fruita') {
                    echo '<h3> '. $key. '</h3>';
                    echo '<ul>';
                    foreach ($value as $key2 => $value2) {
                        echo '<li>'. $value2. '</li>';
                    }
                    echo '</ul>';
                }
                else if ($key == 'peix') {
                    echo '<h3> '. $key. '</h3>';
                    echo '<ul>';
                    foreach ($value as $key3 => $value3) {
                        echo '<li>'. $key3. '</li>';
                        echo '<ul>';
                        foreach ($value3 as $key4 => $value4) {
                            echo '<li>'. $value4. '</li>';
                        }
                        echo '</ul>';
                    }
                    echo '</ul>';
                }
                else if ($key == 'carn') {
                    echo '<h3> '. $key. '</h3>';
                    echo '<ul>';
                    foreach ($value as $key5 => $value5) {
                        echo '<li>'. $value5. '</li>';
                    }
                    echo '</ul>';
                }
            }
        ?>
    </body> 
</html> 