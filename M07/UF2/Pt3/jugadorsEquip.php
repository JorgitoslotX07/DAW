<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jugadorsEquip.php</title>
    <link rel="stylesheet" href="estilosPendejos.css">
</head>
<body>
    <?php
        $mysqli = new mysqli('localhost', 'root', '1234', 'worldcup'); 

        if($mysqli->connect_error){  
            die("Error en la conexión" . $mysqli->connect_error);
        } else {
            $SQL = "SELECT COUNT(*) as total FROM players "; // Contar el número total de filas

            if (isset($_GET['nom']) && $_GET['nom'] != '') {
                $nom = $_GET['nom'];

                $SQL .= "WHERE PLAY_TEAM_Country = '" . $nom . "'";
            } 
            
            $resultadosPorPagina = 10; // Puedes ajustar según sea necesario
            $paginaActual = isset($_GET['pagina']) ? $_GET['pagina'] : 1;
            $inicio = ($paginaActual - 1) * $resultadosPorPagina;

            $resultadoTotal = $mysqli->query($SQL);
            $totalFilas = $resultadoTotal->fetch_assoc()['total'];


            $SQL = "SELECT * FROM players ";

            if (isset($_GET['nom']) && $_GET['nom'] != '') {
                $nom = $_GET['nom'];

                $SQL .= "WHERE PLAY_TEAM_Country = '" . $nom . "'";

                // localhost/M07/UF2/Pt3/jugadorsEquip.php?nom=Spain
            } 
            
            $SQL .= " LIMIT $inicio, $resultadosPorPagina";

            if ($resultado = $mysqli->query($SQL)) {
                echo "<h1>Lista de Jugadores</h1>";

                while ($row = $resultado->fetch_assoc()) {
                    echo "<p>" . $row["PLAY_ID"] . " | " . $row["PLAY_Name"]   . 
                        " | " . $row["PLAY_Number"] . " | " . $row["PLAY_FullName"] 
                        . " | " . $row["PLAY_Birthdate"] . " | $" . $row["PLAY_Position"]
                        . " | " . $row["PLAY_TEAM_Country"] . "</p>";           
                }

                
                $paginaAnterior = $paginaActual - 1;
                $paginaSiguiente = $paginaActual + 1;

                echo "<div>";
                if ($paginaAnterior > 1) {
                    echo "<a href='jugadorsEquip.php?nom=$nom&pagina=1'> << </a> ";
                }
                if ($paginaAnterior > 0) {
                    echo "<a href='jugadorsEquip.php?nom=$nom&pagina=$paginaAnterior'> < </a> ";
                }
                

                $min = max(1, $paginaActual - 5);
                $max = min(ceil($totalFilas / $resultadosPorPagina), $min + 9);

                for ($i = $min; $i <= $max; $i++) {
                    echo "<a href='jugadorsEquip.php?nom=$nom&pagina=$i'>$i</a> ";
                }

                if ($paginaSiguiente <= ceil($totalFilas / $resultadosPorPagina)) {
                    echo "<a href='jugadorsEquip.php?nom=$nom&pagina=$paginaSiguiente'> > </a>";
                }
                if ($paginaSiguiente < ceil($totalFilas / $resultadosPorPagina)) {
                    echo "<a href='jugadorsEquip.php?nom=$nom&pagina=" . ceil($totalFilas / $resultadosPorPagina) ." '> >> </a>";
                }
                echo "</div>";
                
                $resultado->close();
            }
        }
    ?>
</body>
</html>
