function euromillon(numeros, estrellas){
    this.numeros = ordenarLista(numeros);
    this.estrellas = ordenarLista(estrellas);
}

function eliminarDuplicados(lista){
    lista.filter((valor,index)=>{
        return lista.indexOf(valor) === index;
    })

    return lista;
}

function ordenarLista(lista){
    return lista.sort(function(a,b){return a-b});
}

function generarNumeros(min = 1, max = 100){
    return Math.round(Math.random() * (max - min) + min);
}

function generarNumerosNoRepetidos(cantidad, min = 1, max = 100){
    let numeros = [];
    for(let i = 0; i < cantidad; i++){
        let numero = generarNumeros(min, max);
        if (numeros.includes(numero)) {
            i--;
        }
        else {
            numeros.push(numero);
        }
    }
    return numeros
}

function getDatos(){
    let numerosUsuario = document.getElementById("numeros").value;
    let estrellasUsuario = document.getElementById("estrellas").value;

    numerosUsuario = conversionNumber(eliminarAgregados(numerosUsuario.trim().split(',')));
    estrellasUsuario = conversionNumber(eliminarAgregados(estrellasUsuario.trim().split(',')));


    validacionCantidadNumeros(5, numerosUsuario, 'numeros');
    validacionCantidadNumeros(2, estrellasUsuario, 'estrellas');

    alerta = false;
    if (validacionNumeros(1, 50, numerosUsuario, 'los numeros', alerta)) {
        numerosUsuario = [];
        alerta = true;
    }
    if (validacionNumeros(1, 12, estrellasUsuario, 'las estrellas', alerta)) {
        estrellasUsuario = [];
    }

    return new euromillon(numerosUsuario, estrellasUsuario);
}

function conversionNumber(listaNumerosStr = []) {
    listaNumerosInt = [];

    listaNumerosStr.forEach(data => {
        data = parseInt(data, 10);
        listaNumerosInt.push(data);
    });

    return listaNumerosInt;
}

function noSeRepite(lista, valor) {
    const filtrado = lista.filter(item => item === valor);
    return filtrado.length > 1;
}

function validacionNumeros(min = 0, max = 100 , listaNumeros = [], tipo = 'los numeros', alerta = false) {
    for (i = 0; i < listaNumeros.length; i++) {
        if ((listaNumeros[i] < min || listaNumeros[i] > max) && !alerta) {
            alert("Todos " + tipo + " tiene que ser enteros y entre " + min + '-' + max); 
            alerta = true;
        }
        if ((noSeRepite(listaNumeros, listaNumeros[i])) && !alerta) {
            alert("No se pueden repetir " + tipo + " introducidos"); 
            alerta = true;
        }
    }

    return alerta;
}

function validacionCantidadNumeros(cantidad, numeros, tipo = "numeros") {
    if (cantidad != numeros.length) {
        stringNum = "";
        for (let i = 1; i <= numeros.length; i++) {
            stringNum = stringNum + i + " "
        }
        alert("La cantidad de " + tipo + " a introducir es " + cantidad + "\n Ej: " + stringNum)
    }
}

function obtenerDiaSemana() {
    const diasSemana = ["domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado"];
    const fecha = new Date();
    const diaSemana = diasSemana[fecha.getDay()];
    return diaSemana;
}

function obtenerFecha() {
    const fecha = new Date();
    const dia = fecha.getDate();
    const mes = fecha.toLocaleDateString("default", { month: "long" });
    const año = fecha.getFullYear();
    return `${dia} de ${mes} de ${año}`;
}

function obtenerHora() {
    const fecha = new Date();
    const hora = fecha.getHours().toString().padStart(2, "0");
    const minutos = fecha.getMinutes().toString().padStart(2, "0");
    return `${hora}:${minutos}`;
}

function mostrarFechaYHora() {
    const diaSemana = obtenerDiaSemana();
    const fecha = obtenerFecha();
    const hora = obtenerHora();
    const mensaje = `Avui és ${diaSemana} ${fecha} i són les ${hora} hores.`;
    document.getElementById("fechaHora").textContent = mensaje;
}

function generarClave(){
    let numerosClave = generarNumerosNoRepetidos(5, 1, 51);
    let estrellasClave = generarNumerosNoRepetidos(2, 1, 13);

    return new euromillon(numerosClave, estrellasClave);
}

function eliminarAgregados(palabras) {
    for (var i = palabras.length -1; i != 0; i--) {
        if (palabras[i] == ''){
            palabras.splice(i, 1)
        }
    }

    return palabras
}

function verificarAciertos(datosClave, datosUsuario) {
    var numAciertos = verificarNumerosAciertos(datosClave.numeros, datosUsuario.numeros);
    console.log('numAciertos');
    console.log(numAciertos);

    var estAciertos = verificarNumerosAciertos(datosClave.estrellas, datosUsuario.estrellas);
    console.log('estAciertos');
    console.log(estAciertos);

    if (numAciertos == 5 && estAciertos == 2) {
        console.log("¡Felicidades! Has acertado la combinación ganadora.");
        document.getElementById("resultado").textContent = "¡Felicidades! Has acertado la combinación ganadora.";
    } 
    else {
    console.log("Lo siento, no has acertado la combinación ganadora.");
    document.getElementById("resultado").textContent = "Lo siento, no has acertado la combinación ganadora.";
    }
}

function verificarNumerosAciertos(numerosClave, numerosUsuario) {
    var numExito = 0
    for (var i = 0; i < numerosClave.length; i++) {
        if (numerosClave[i] == numerosUsuario[i]) {
            numExito += 1;
        }
    }

    return numExito;
}


function validarDatos(){

    datosClave = this.datosClave;
    datosUsuario = getDatos();

    console.log('datosClave');
    console.log(datosClave);
    console.log('datosUsuario');
    console.log(datosUsuario);



    let veri = document.getElementById("veri");
    veri.innerHTML = 'Numeros clave: ' + datosClave['numeros'] + '<br>' + 'Estrellas clave: ' + datosClave['estrellas'];


    verificarAciertos(datosClave, datosUsuario);

    //fin crono
    var fin = new Date().getTime();
    var tiempoEjecucion = (fin - this.inicio) / 1000;
    console.log("Tiempo de ejecución -> ", tiempoEjecucion.toFixed(2) + " segundos");
}

//iniciar crono
var inicio = new Date().getTime(); 

window.onload = mostrarFechaYHora;
datosClave = generarClave();
console.log('Clave ganadora:\nNumeoros -> ' + datosClave['numeros'] + '\nEstrellas -> ' + datosClave['estrellas']);
