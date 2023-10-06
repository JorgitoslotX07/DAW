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

    console.log(validacionNumeros(1, 50, numerosUsuario));
    console.log(validacionNumeros(1, 12, estrellasUsuario));
    if (validacionNumeros(1, 50, numerosUsuario)) {
        numerosUsuario = [];
    }
    if (validacionNumeros(1, 12, estrellasUsuario)) {
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
    return filtrado.length <= 1;
  }

function validacionNumeros(min = 0, max = 100 , listaNumeros = []) {
    for (i = 0; i < listaNumeros.length; i++) {
        if (listaNumeros[i] <= min || listaNumeros[i] >= max) {
            alert("Todos numeros tiene que ser enteros y entre " + min + '-' + max); 
            return true;
        }
        if (noSeRepite(listaNumeros, listaNumeros[i])) {
            alert("No se pueden repetir los numeros introducidos"); 
            console.log("No se pueden repetir los numeros introducidos");
            return true;
        }
    }

    return false;
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

function generarClave(){
    let numerosClave = generarNumerosNoRepetidos(5, 1, 50);
    let estrellasClave = generarNumerosNoRepetidos(2, 1, 12);

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

function validarDatos(){
    //iniciar crono

    datosClave = this.datosClave;
    datosUsuario = getDatos();

    console.log(datosClave);
    console.log(datosUsuario);



    let veri = document.getElementById("veri");
    veri.innerHTML = 'Numeros clave: ' + datosClave['numeros'] + '<br>' + 'Estrellas clave: ' + datosClave['estrellas'];
    //finalizar crono
}

datosClave = generarClave();
console.log('Clave ganadora:\nNumeoros -> ' + datosClave['numeros'] + '\nEstrellas -> ' + datosClave['estrellas']);
