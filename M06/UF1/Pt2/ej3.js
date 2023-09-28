var frase = prompt('Frase --> ');
var palabras = frase.split(' ');

var numero_palabras = eliminar_espacios(palabras).length;
//hola como      va
console.log(numero_palabras);
console.log(palabras);

function eliminar_espacios(palabras) {
    for (var i = palabras.length -1; i != 0; i--) {
        if (palabras[i] == ''){
            palabras.splice(i, 1)
        }
    }
    return palabras
}