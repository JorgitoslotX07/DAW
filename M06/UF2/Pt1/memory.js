let select = document.getElementById('difficulty');
tarjetas();

select.addEventListener('change', tarjetas);

let img = [
    'gripen.jpg', 
    'mig29.jpg', 
    'f16.jpg', 
    'eurofighter.jpg', 
    'f14.jpg'
]
var imgEnv = mezcalarBaraja([...img, ...img]);
//var imgEnv = []; // mezcalarBaraja([...img, ...img]);

var car = []
var estadosDivs = {};

var cartasDadasVuelta = 0;
var cartaEnEspera = null;

function reiniciarJuego() {
    cartasDadasVuelta = 0;
    cartaEnEspera = null;

    iniciarEstadosDivs(20);
}

function iniciarEstadosDivs(can) { 
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

    miDiv.innerHTML = '';

    if (select.value == 'easy') {
        //imgEnv = mezcalarBaraja([...img, ...img]);
        monTarjeta(10)
    } else if (select.value == 'medium') {
        monTarjeta(16)
    } else {
        monTarjeta(imgEnv, 20)
    }
}

function mezcalarBaraja(imgs) {
    let imgTemp = [...imgs];
    let imgEnv = [];

    for (var j = 0; j < imgs.length; j++) {
        let num = numRandom(imgTemp.length);

        imgEnv.push(imgTemp[num]);

        imgTemp.splice(num, 1);
    }
    return imgEnv;
}

function monTarjeta(can) {
    for (var j = 0; j < can; j++) {
        //carta(img[num]);
        carta('reversa.jpg', j);
    }
}

function carta(img, num) {
    let carta = document.createElement('div');

    carta.className = 'card';
    carta.id = 'caza' + num;
    
    carta.style.backgroundImage = 'url(img/' + img + ')';

    carta.addEventListener('click', function() {
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


