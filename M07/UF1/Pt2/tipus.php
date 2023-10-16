<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>tipus.php</title>
</head>
<body>
    <?php
        $x = 10; 
        $y = "10"; 
        $z = $x * 2; 
        $a = "23 anys"; 
        $b = $x + 11; 
        $c = 1.234; 
        $d = 1.2e3; 
        $e = 7E-10; 
        $f = NULL; 
        
        $list = array($x, $y, $z, $a, $b, $c, $d, $e, $f); 

        foreach ($list as $value) {
            echo $value . ' --> ' . gettype($value) . "<br>";
        }
    ?>
</body>
</html>