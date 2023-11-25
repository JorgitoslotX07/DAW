<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>consultaFabricants.php</title>
    <link rel="stylesheet" href="estilosPendejos.css">
</head>
<body>
    <?php
        $mysqli = new mysqli('localhost', 'root', '1234', 'tienda'); 

        if($mysqli->connect_error){  
            die("Error en la conexión" . $mysqli->connect_error);
        } else {
            $SQL = "SELECT * FROM fabricante ";

            if (isset($_GET['nom'])) {
                $nom = $_GET['nom'];

                $SQL .= "WHERE nombre = '" . $nom . "'";

                // localhost/M07/UF2/Pt3/consultaFabricants.php?nom=Asus
            } 

            if ($resultado = $mysqli->query($SQL)) {
                echo "<h1>Lista de Productos</h1>";

                while ($row = $resultado->fetch_assoc()) {
                    echo "<p>" . $row["codigo"]  . " | " . $row["nombre"] . "</p>";           
                }
                $resultado->close();
            }
        }
    ?>
</body>
</html>
