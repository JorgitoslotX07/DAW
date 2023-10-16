<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica6b.php</title> 
    </head> 
    <body>
        <h1>Inserción de vivienda</h1>

        <?php
        if (isset($_REQUEST['enviar'])) {
            if (is_numeric($_POST["euros"])) {
                $euros = $_POST["euros"];
                $moneda = $_POST["moneda"];
                $result = 0;
                if ($moneda == "dolar") {
                    $result = $euros * 1.325;
                }
                elseif ($moneda == "lliures") {
                    $result = $euros * 0.927;
                }
                elseif ($moneda == "iens") {
                    $result = $euros * 118.232;
                }
                elseif ($moneda == "francs") {
                    $result = $euros * 1.515;
                }

                echo "{$euros} euros equivalen a {$result} {$moneda}";
            }
            else {
                echo "<p>Debe introducir una contidad</p>";
            }

            echo "<p>( <a href='practica6a.php'>Volver al inicio</a> )</p>";
        }
        else {

            function select($arr) {
                for ($i = 0; $i < count($arr); $i++) {
                    echo '<option value="' . $arr[$i] . '">' 
                    . $arr[$i] . '</option>';
                } 
            }

            $tipoHabitatge = [
                'Pis',
                'Adossat',
                'Xalet',
                'Casa'
            ];

            $zonaHabitatge = [
                'Centre',
                'Nervion',
                'Triana',
                'Aljarafe',
                'Macarena'
            ];

            $nMinDormitorios = 1;
            $nMaxDormitarios = 5;

            $extras = [
                'Piscina',
                'Jardí',
                'Garage'
            ];
        ?>       

        <p>Introduzca los datos de vivienda</p>

        <form method="post" action="practica6a.php">
            <label for="tipoHabitatge">Tipo de vivienda: </label>
            <select name="tipoHabitatge" id="tipoHabitatge">
                <?php
                select($tipoHabitatge);
                ?>
            </select>
            <br>
            <label for="zonaHabitatge">Zona: </label>
            <select name="zonaHabitatge" id="zonaHabitatge">
                <?php
                select($zonaHabitatge);
                ?>
            </select>
            <br>
            <label for="direc">Dirección: : </label>
            <input type="text" name="direc" id="direc">
            <br>
            <label for="nDormitorios">Tipo de vivienda: </label>
                <?php
                for ($i = $nMinDormitorios; $i <= $nMaxDormitarios; $i++) {
                    echo '<input type="radio" name"nDormitorios id="n' . $i . '">';
                    echo '<label for="n' . $i . '">' . $i . '</label>';
                }
                ?>
            <br>
            <label for="euros">Precio: </label>
            <input type="number" name="euros" id="euros">
            <label for="euros">€</label>
            <br>
            <label for="tamano">Tamaño: </label>
            <input type="number" name="tamano" id="tamano">
            <br>
            <label for="nDormitorios">Extras: </label>
                <?php
                for ($i = 0; $i < count($extras); $i++) {
                    echo '<input type="checkbox" name="' . $extras[$i] 
                    . '" id="' . $extras[$i] . '">';
                    echo '<label for="' . $extras[$i] . '">' 
                    . $extras[$i] . '</label>';
                }
                ?>
            <br>
            <label for="observaciones">Observaciones</label>
            <textarea rows="10" cols="50" name="observaciones" id="observaciones">
            </textarea>
            <br>
            <input type="submit" value="Convertir" name="enviar">
        </form>

        <?php 
        }
        ?>
    </body> 
</html> 