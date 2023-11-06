function Personaje(id, nom, intel, forca, agil, tecni) {
    this.id = id;
    this.nom = nom;
    this.intel = intel;
    this.forca = forca;
    this.agil = agil;
    this.tecni = tecni;
}

function entrar() {
    var nom = document.getElementById("nom").value;
    var fecha = document.getElementById("fecha").value;

    // console.log(nom, fecha);

    // comprobacion fecha, por hacer

    var date = new Date();

    if (nom == "") {
        alert("Debe introducir el nombre");
    }
    else if (this.getAnio(fecha) >= date.getFullYear()) {
        alert("No se aceptan menores de 1 año y/o viajeros temporales");
    }
    else if (fecha == "") {
        alert("Debe introducir la fecha de nacimiento");
    }
    else {
        localStorage.setItem('nom', nom);
        localStorage.setItem('fecha', fecha);

        location.href = "p1_2.html";
    }
}

function onLoad() {
    edad();
    bienvenida();
}

function edad() {
    var anio = getAnio();
    var date = new Date();

    // console.log(anio);

    if (anio + 18 <= date.getFullYear()) {
        var mortLabel = document.createElement('label');
        var mortInput_1 = document.createElement('input');

        mortLabel.textContent = 'Mort';

        mortInput_1.type = 'radio';
        mortInput_1.name = 'mort';
        mortInput_1.value = 'si';

        //document.body.div.appendChild(mortLabel);
    }


}

function getAnio(fecha = localStorage.getItem('fecha')) {
    var fechas = fecha.split("-");
    
    return parseInt(fechas[0]);
}

function bienvenida() {
    var date = new Date();

    var hora = date.getHours()

    if (hora > 8 && hora < 13) {
        document.getElementById('bienvenida').innerHTML = "Buenos dias " + this.getNom()
    }
    else if (hora >= 13 && hora < 20) {
        document.getElementById('bienvenida').innerHTML = "Buenas tardes " + this.getNom()
    }
    else {
        document.getElementById('bienvenida').innerHTML = "Buenas noches " + this.getNom()
    }

    // console.log(date)
    // console.log(date.getFullYear())
}

function getNom() {
    return localStorage.getItem('nom')
}

function comenzar() {
    var id = document.getElementById("id").value
    var nom = document.getElementById("nom").value
    var intel = document.getElementById("intel").value
    var forca = document.getElementById("forca").value
    var agil = document.getElementById("agil").value
    var tecni = document.getElementById("tecni").value
    
    var puntos = numero(forca) + numero(agil) + numero(tecni)
    // console.log(puntos)
    if (puntos > 8 ) {
        alert("La suma de força, agilitat y tecnica NO te que ser superior a 8 punts");
    }
    else if (forca > 5) { 
        alert("La força teque estar entre el seguent parametre (0 - 5)");
    }
    else if (agil > 5) { 
        alert("La agillitat teque estar entre el seguent parametre (0 - 5)");
    }
    else if (tecni > 3) { 
        alert("La tecnica teque estar entre el seguent parametre (0 - 3)");
    }
    else if (forca < 0 || agil < 0 || tecni < 0) { 
        alert("La força tecnica y agilitat te que ser superior o igual a 0");
    } 
    else if (!comprobaNum(id)) {
        alert("El ID tiene que ser numerico");
    }
    else if (id.split('') > 9) {
        alert("El ID tiene que tener 4 nuermos");
    }
    else {

        nom = nom.toUpperCase();
        var personaje = new Personaje(id, nom, intel, forca, agil, tecni)

        if (comprobaPersonaje(personaje)) {
            alert("El ID del personaje no se puede repetir");

            var p = document.createElement("p");
            p.innerHTML = "ID: " + personaje.id + " Nom: " + personaje.nom + " Intel: " + personaje.intel + " Força: " + personaje.forca 
                + " Agil: " + personaje.agil + " Tecni: " + personaje.tecni;

            document.body.appendChild(p);
        }
        else {
            setPersonaje(personaje);
        }
    }
}

function comprobaPersonaje(personaje) {
    var personajes = getPersonaje()

    // console.log(personajes)

    for (let i = 0; i < personajes.length; i++) {
        // console.log(personajes[i]['personaje'])
        // console.log(personaje['id'])
        if (personajes[i]['personaje']['id'] == personaje['id']) {
            return true;
        }   
    }
    return false;
}

function setPersonaje(perso) {

    let key = localStorage.getItem('keyPerso') || 1;
    let personajeKey = "personaje" + key;

    localStorage.setItem(personajeKey, JSON.stringify(perso));

    key++;
    localStorage.setItem('keyPerso', key);
}

function getPersonaje() {
    let personajes = [];
    for (let i = 0; i < localStorage.length; i++) {
        let key = localStorage.key(i);
        if (key.startsWith("personaje")) {
            let personajeString = localStorage.getItem(key);
            let personaje = JSON.parse(personajeString);
            personajes.push(
                {
                    key: key,
                    personaje: personaje
                }
            );
        }
    }

    personajes.sort((a, b) => {
        let keyA = parseInt(a.key.replace('personaje', ''), 10);
        let keyB = parseInt(b.key.replace('personaje', ''), 10);
        return keyA - keyB;
    });
    console.log(personajes);

    return personajes;
}


function numero(num) {
    var numVal = parseInt(num, 10);
    if (numVal) {
        return numVal;
    } else {
        return 0
    }
}

function comprobaNum(num) {
    var numVal = parseInt(num, 10);
    if (numVal) {
        return true;
    } else {
        return false
    }
}