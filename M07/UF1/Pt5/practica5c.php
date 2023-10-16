<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica5c.php</title> 
    </head> 
    <body>
        <h1>Generación de formularios desde PHP</h1>

        <?php
            $notesActivitats = array(7.5, 4.3, 5.0, 7.7, 8.0, 9.0, 5.5, 4.1, 8.2);
            $selectedValue = $notesActivitats[rand(1, count($notesActivitats)) -1];
        ?>

        <form method="post" action="practica5c-resultados.php">
            <label for="notes">Selecciona una nota:</label>
            
            <select name="notes" id="notes">
        <?php
            foreach ($notesActivitats as $nota) {
                $selected = ($nota == $selectedValue) ? 'selected' : '';
                echo "<option value='$nota' $selected>$nota</option>";
            }
        ?>
            </select>
            <input type="submit" value="seleccionar">
        </form>

    </body> 
</html> 