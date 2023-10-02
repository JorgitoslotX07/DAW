function euromillon(numeros, estrellas){
    this.numeros = ordenarLista(numeros);
    this.estrellas = ordenarLista(estrellas);
}

/*
function eliminarEspacios(lista) {
    for (var i = lista.length -1; i != 0; i--) {
        if (lista[i] == ''){
            lista.splice(i, 1)
        }
    }
    return lista
}
*/

function eliminarDuplicados(lista){
    lista.filter((valor,index)=>{
        // console.log('item -> ' + valor);
        // console.log('index -> ' +index);
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

        if (numero in numeros) {
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

    numerosUsuario = eliminarAgregados(numerosUsuario.trim().split(','));
    estrellasUsuario = eliminarAgregados(estrellasUsuario.trim().split(','));

    validacionCantidadNumeros(5, numerosUsuario, 'numeros');
    validacionCantidadNumeros(2, estrellasUsuario, 'estrellas');

    return new euromillon(numerosUsuario, estrellasUsuario);
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

    datosUsuario = getDatos();
    datosClave = generarClave();

    console.log(datosClave);
    console.log(datosUsuario);
    let veri = document.getElementById("veri");
    veri.innerHTML = 'Numeros clave: ' + datosClave['numeros'] + '<br>' + 'Estrellas clave: ' + datosClave['estrellas'];
    //finalizar crono
}
