<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>practica8.php</title> 
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

        $vFoto = false;
        $mFoto = false;

        $error = false;

        if (isset($_POST['enviar'])) {
            $error = true;
        }

        if (isset($_FILES['foto'])) {
            if ($_FILES['foto']['size'] <= 100000) {
                $vFoto = true;

                $url = 'fotos/'; 
                $filename = $_FILES['foto']['name'];
                $file_tmp = $_FILES['foto']['tmp_name'];
                $file_size = $_FILES['foto']['size'];

                move_uploaded_file($file_tmp, $url . $filename);
            }
            else {
                $mFoto = true;
            }
        }

        if (isset($_POST['direc']) && isset($_POST['nDormitorios']) && !$mFoto
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
            if ($vFoto) {
                echo "<li>Foto: <a href='fotos/$filename' target='_blank'>$filename</a></li>";
            }
            if (isset($_POST['observaciones']) && $_POST['observaciones'] != "") {
                echo "<li>Observaciones: {$_POST['observaciones']}</li>";
            }

            echo '</ul>';

            echo '<br>';
            echo "<p>[ <a href='practica8.php'>Insertar otra vivienda</a> ]</p>";
                
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
        
        <form method="post" action="practica8.php" enctype="multipart/form-data">
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
                        <?php 
                        if ($error) {
                            if (!isset($_POST['direc']) || $_POST['direc'] == "") {
                                echo '<p style="color: red;">¡Se requiere la Direccion de la vivienda!</p>';
                            }
                        }
                        ?>
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
                        
                        if ($error) {
                            if (!isset($_POST['nDormitorios'])) {
                                echo '<p style="color: red;">¡No se ha introducido el Numero de Dormitorios!</p>';
                            }
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
                        <?php 
                        if ($error) {
                            if (!isset($_POST['euros']) || $_POST['euros'] == "") {
                                echo '<p style="color: red;">¡No se introducido el Precio!</p>';
                            }
                            elseif (!is_numeric($_POST['euros'])) {
                                echo '<p style="color: red;">¡El Precio deve ser un valor numerico</p>';
                            }
                        }
                        ?>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="tamano">Tamaño: </label>
                    </td>
                    <td>
                        <input type="text" name="tamano" id="tamano">
                        <label for="euros">metros cuadrados</label>
                        <?php 
                        if ($error) {
                            if (!isset($_POST['tamano']) || $_POST['tamano'] == "") {
                                echo '<p style="color: red;">¡No se ha introducio el Tamaño!</p>';
                            }
                            elseif (!is_numeric($_POST['tamano'])) {
                                echo '<p style="color: red;">¡El Tamaño deve ser un valor numerico!</p>';
                            }
                        }
                        ?>
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
                </tr>
                <tr>
                    <td>
                        <label for="foto">Foto: </label>
                    </td>
                    <td>
                        <input type="file" name="foto" id="foto">
                        <?php 
                        if ($error) {
                            if ($mFoto) {
                                echo '<p style="color: red;">¡No se ha podido subir el fichero!</p>';
                            }
                        }
                        ?>
                    </td>
                </tr>

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