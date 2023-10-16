<!DOCTYPE html>
<html lang="en">
    <head> 
        <meta charset="UTF-8">
        <title>pagina1.php</title> 
    </head> 
    <body>
        <form action="pagina2.php" method="POST">
            <label for="nom">Nom: </label>
            <input type="text" name="nom" id="nom">
            <br>
            <label for="cognoms">Cognoms: </label>
            <input type="text" name="cognoms" id="cognoms">
            <br>
            <label for="edat">Edat: </label>
            <input type="number" name="edat" id="edat">
            <br>
            <label for="adreca">Adreça: </label>
            <input type="text" name="adreca" id="adreca">
            <br>
            <label for="provincia">Província on resideix: </label>
            <select name="provincia" id="provincia">
                <option value="lleida">Lleida</option>
                <option value="tarragona">Tarragona</option>
                <option value="barcelona">Barcelona</option>
                <option value="girona">Girona</option>
            </select>
            <br>
            <label for="telefon">Telèfon: </label>
            <input type="number" name="telefon" id="telefon">
            <br>
            <label for="email">Email: </label>
            <input type="text" name="email" id="email">
            <br>
            <label for="color">Color preferit: </label>
            <input type="text" name="color" id="color">
            <br>
            <label for="cicle">Cicle que estudia: </label>
            <select name="cicle" id="cicle">
                <option value="smx">SMX,</option>
                <option value="asix">ASIX</option>
                <option value="dam">DAM</option>
                <option value="daw">DAW</option>
            </select>
            <br>
            <label>Estat cívil: </label> <br>
                <label for="solter">Solter</label>
                <input type="radio" name="estCivil" value="solter" id="solter">
                <label for="casat">Casat</label>
                <input type="radio" name="estCivil" value="casat" id="casat">
                <label for="separat">Separat</label>
                <input type="radio" name="estCivil" value="separat" id="separat">
                <label for="viudo">Víudo</label>
                <input type="radio" name="estCivil" value="viudo" id="viudo">
            <br>
            <label>Estat professional: </label> <br>
                <label for="estudiant">Estudiant</label>
                <input type="checkbox" value="estudiant" id="estudiant" name="estudiant">
                <label for="treballador">Treballador</label>
                <input type="checkbox" value="treballador" id="treballador" name="treballador">
            <br>
            <input type="submit">
        </form>
    </body> 
</html> 