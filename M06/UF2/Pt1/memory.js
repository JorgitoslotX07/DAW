let select = document.getElementById('difficulty');
select.addEventListener('change', tarjetas);


var imgEnv = [];

var estadosDivs = {};
var cartasDadasVuelta = 0;
var cartaEnEspera = null;

function reiniciarJuego() {
    cartasDadasVuelta = 0;
    cartaEnEspera = null;
    iniciarEstadosDivs(20);
}

function iniciarEstadosDivs(can) {
    estadosDivs = {}; 
    for (let i = 0; i < can; i++) {
        estadosDivs['caza' + i] = false;
    }
}

iniciarEstadosDivs(20);

function actualizarEstadoDiv(id) {
    estadosDivs[id] = !estadosDivs[id];
}

function cambiarImagenDiv(div, estado, num) {
    if (estado) {
        div.style.backgroundImage = 'url(img/' + imgEnv[num] + ')';
    } else {
        div.style.backgroundImage = 'url(img/reversa.jpg)';
    }
}

function tarjetas() {
    let miDiv = document.getElementById('memory-board');
    var img = [
        'gripen.jpg', 
        'mig29.jpg', 
        'f16.jpg', 
        'eurofighter.jpg', 
        'f14.jpg',
        'mirage2000.jpg',
        'su35.jpg',
        'tornado.jpg',
        'f22.jpg',
        'su57.jpg'
    ];
    var imgRec;

    miDiv.innerHTML = '';

    if (select.value == 'easy') {
        imgRec = obtenerValoresAleatorios(img, 5);
        imgEnv = mezclarBaraja([...imgRec, ...imgRec]);
        monTarjeta(10);
    } else if (select.value == 'medium') {
        imgRec = obtenerValoresAleatorios(img, 8);
        imgEnv = mezclarBaraja([...imgRec, ...imgRec]);
        monTarjeta(16);
    } else {
        imgRec = obtenerValoresAleatorios(img, 10);
        imgEnv = mezclarBaraja([...imgRec, ...imgRec]);
        monTarjeta(20);
    }
}

function obtenerValoresAleatorios(arrayOriginal, can) {
    let arrayCopia = [...arrayOriginal];
    let valoresAleatorios = [];

    for (let i = 0; i < can; i++) {
        let indiceAleatorio = Math.floor(Math.random() * arrayCopia.length);
        valoresAleatorios.push(arrayCopia[indiceAleatorio]);
        arrayCopia.splice(indiceAleatorio, 1);
    }

    return valoresAleatorios;
}

function mezclarBaraja(imgs) {
    let imgTemp = [...imgs];
    let imgEnv = [];

    while (imgTemp.length > 0) {
        let num = numRandom(imgTemp.length);
        imgEnv.push(imgTemp[num]);
        imgTemp.splice(num, 1);
    }

    return imgEnv;
}

function monTarjeta(can) {
    for (var j = 0; j < can; j++) {
        carta('reversa.jpg', j);
    }
}

function carta(img, num) {
    let carta = document.createElement('div');

    carta.className = 'card';
    carta.id = 'caza' + num;

    carta.style.backgroundImage = 'url(img/' + img + ')';

    carta.addEventListener('click', function () {
        actualizarEstadoDiv(this.id);
        cambiarImagenDiv(this, estadosDivs[this.id], num);

        cartasDadasVuelta++;

        if (cartasDadasVuelta === 1) {
            cartaEnEspera = this;
        } else if (cartasDadasVuelta === 2) {
            setTimeout(() => verificarCartas(cartaEnEspera, this, num), 1000);
        }

    });

    let mesa = document.getElementById('memory-board');
    mesa.appendChild(carta);
}

function numRandom(max) {
    return Math.floor(Math.random() * max);
}

function verificarCartas(carta1, carta2, num) {
    if (carta1.style.backgroundImage === carta2.style.backgroundImage) {
        cartasDadasVuelta = 0;
    } else {
        cambiarImagenDiv(carta1, false, null);
        cambiarImagenDiv(carta2, false, null);

        actualizarEstadoDiv(carta1.id);
        actualizarEstadoDiv(carta2.id);

        cartasDadasVuelta = 0;
    }
}


tarjetas();