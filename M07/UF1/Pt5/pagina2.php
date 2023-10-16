<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>pagina2.php</title> 
    </head> 
    <body>
        <h1>Info</h1>
        <?php
            $nom = $_POST['nom'];
            $cognoms = $_POST['cognoms'];
            $edat = $_POST['edat'];
            $adreca = $_POST['adreca'];
            $provincia = $_POST['provincia'];
            $telefon = $_POST['telefon'];
            $email = $_POST['email'];
            $color = $_POST['color'];
            $cicle = $_POST['cicle'];
            $estCivil = $_POST['estCivil'];
            $estudiant = $_POST['estudiant'];
            $treballador = $_POST['treballador'];

            echo $nom;
            echo '<br>';
            echo $cognoms;
            echo '<br>';
            echo $edat;
            echo '<br>';
            echo $adreca;
            echo '<br>';
            echo $provincia;
            echo '<br>';
            echo $telefon;
            echo '<br>';
            echo $email;
            echo '<br>';
            echo $color;
            echo '<br>';
            echo $cicle;
            echo '<br>';
            echo $estCivil;
            echo '<br>';
            echo $estudiant;
            echo '<br>';
            echo $treballador;
            
        ?>
    </body> 
</html> 