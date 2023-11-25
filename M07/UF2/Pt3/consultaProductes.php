<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>consultaProductes.php</title>
    <link rel="stylesheet" href="estilosPendejos.css">
</head>
<body>
    <?php
        $mysqli = new mysqli('localhost', 'root', '1234', 'tienda'); 

        if($mysqli->connect_error){  
            die("Error en la conexión" . $mysqli->connect_error);
        } else {
            $SQL = "SELECT * FROM producto ";

            if (isset($_GET['nom'])) {
                $nom = $_GET['nom'];

                $SQL .= "WHERE nombre = '" . $nom . "'";

                // localhost/M07/UF2/Pt3/consultaProductes.php?nom=Disco SSD 1 TB
            } 

            if ($resultado = $mysqli->query($SQL)) {
                echo "<h1>Lista de Productos</h1>";

                while ($row = $resultado->fetch_assoc()) {
                    echo "<p>" . $row["codigo"]  . " | " . $row["nombre"] . " | $" . $row["precio"]
                        . " | Fabricante: " . $row["codigo_fabricante"] . "</p>";           
                }
                $resultado->close();
            }
        }
    ?>
</body>
</html>
