<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica6b.php</title> 
    </head> 
    <body>
        <h1>Inserción de vivienda</h1>

        <?php
        $extras = [
            'Piscina',
            'Jardí',
            'Garage'
        ];

        function vExtras($extras) {
            for ($i = 0; $i < count($extras); $i++) {
                if (isset($_POST[$extras[$i]])) {
                    return true;
                }
            }
            return false;
        }

        function rExtras($extras) {
            $arr = "";
            for ($i = 0; $i < count($extras); $i++) {
                if (isset($_POST[$extras[$i]])) {
                    if ($arr != "") {
                        $arr = $arr . ', ';
                    }
                    $arr = $arr . $extras[$i];
                }
            }
            return $arr;
        }

        if (isset($_REQUEST['enviar'])) {
            if (isset($_POST['direc']) && isset($_POST['nDormitorios']) 
                && isset($_POST['euros']) && isset($_POST['tamano'])
                && is_numeric(($_POST['euros'])) && is_numeric(($_POST['tamano']))) {

                echo '<p>Estos son los datos introducidos</p>';
                echo '<br>';
                
                echo '<ul>';
                echo "<li>Tipo: {$_POST['tipoHabitatge']}</li>";
                echo "<li>Zona: {$_POST['zonaHabitatge']}</li>";
                echo "<li>Dirección: {$_POST['direc']}</li>";
                echo "<li>Numero de dormitorios: {$_POST['nDormitorios']}</li>";
                echo "<li>Precio: {$_POST['euros']}</li>";
                echo "<li>Tamaño: {$_POST['tamano']}</li>";
                if (vExtras($extras)) {
                    echo "<li>Extras: " . rExtras($extras) . "</li>";
                }
                if (isset($_POST['observaciones']) && $_POST['observaciones'] != "") {
                    echo "<li>Observaciones: {$_POST['observaciones']}</li>";
                }

                echo '</ul>';

                echo '<br>';
                echo "<p>[ <a href='practica6b.php'>Insertar otra vivienda</a> ]</p>";

            }
            else {
                echo "<p>No se ha podido realizar la insercion 
                    debido a los siguientes errores:</p>";

                echo '<ul>';
                if (!isset($_POST['direc']) || $_POST['direc'] == "") {
                    echo "<li>Se requiere la Direccion de la vivienda</li>";
                }

                if (!isset($_POST['nDormitorios'])) {
                    echo "<li>No se ha introducido el Numero de Dormitorios</li>";
                }

                if (!isset($_POST['euros']) || $_POST['euros'] == "") {
                    echo "<li>No se introducido el Precio</li>";
                }
                elseif (!is_numeric($_POST['euros'])) {
                    echo "<li>El Precio deve ser un valor numerico</li>";
                }

                if (!isset($_POST['tamano']) || $_POST['tamano'] == "") {
                    echo "<li>No se ha introducio el Tamaño</li>";
                }
                elseif (!is_numeric($_POST['tamano'])) {
                    echo "<li>El Tamaño deve ser un valor numerico</li>";
                }
                echo '</ul>';

                echo "<p>[ <a href='practica6b.php'>Volver</a> ]</p>";
            }

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
        ?>       

        <p>Introduzca los datos de vivienda</p>

        <br>
        
        <form method="post" action="practica6b.php">
            <table style="border: solid blue; padding: 5px;">
                <tr>
                    <td>
                        <label for="tipoHabitatge">Tipo de vivienda: </label>
                    </td>
                    <td>
                        <select name="tipoHabitatge" id="tipoHabitatge">
                            <?php
                            select($tipoHabitatge);
                            ?>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="zonaHabitatge">Zona: </label>
                    </td>
                    <td>
                        <select name="zonaHabitatge" id="zonaHabitatge">
                            <?php
                            select($zonaHabitatge);
                            ?>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="direc">Dirección: : </label>
                    </td>
                    <td>
                        <input type="text" name="direc" id="direc">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="nDormitorios">Numero de dormitorios: </label>
                    </td>
                    <td>
                        <?php
                        for ($i = $nMinDormitorios; $i <= $nMaxDormitarios; $i++) {
                            echo '<input type="radio" name="nDormitorios" id="n' . $i . '" value="'  . $i . '">';
                            echo '<label for="n' . $i . '">' . $i . '</label>';
                        }
                        ?>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="euros">Precio: </label>
                    </td>
                    <td>
                        <input type="text" name="euros" id="euros">
                        <label for="euros">€</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tamano">Tamaño: </label>
                    </td>
                    <td>
                        <input type="text" name="tamano" id="tamano">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="extras">Extras: </label>
                    </td>
                    <td>
                    <?php
                    for ($i = 0; $i < count($extras); $i++) {
                        echo '<input type="checkbox" name="' . $extras[$i] 
                        . '" id="' . $extras[$i] . '">';
                        echo '<label for="' . $extras[$i] . '">' 
                        . $extras[$i] . '</label>';
                    }
                    ?>
                    
                <tr>
                    <td>
                        <label for="observaciones">Observaciones</label>
                    </td>
                    <td>
                        <textarea rows="10" cols="50" name="observaciones" id="observaciones"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="  Insertar vivienda  " name="enviar">
                    </td>
                </tr>
            </table>
        </form>

        <?php 
        }
        ?>
    </body> 
</html> 
