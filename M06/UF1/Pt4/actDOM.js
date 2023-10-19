function boton1() {

    let textP1 = document.getElementById('p1');
    var textP2;
    let textP3 = document.getElementsByTagName('p'); 

    textP1.textContent = 'Nuevo Texto ID';
    
    if (textP3[1].className != "") {
        textP2 = document.getElementsByClassName(textP3[1].className);
        textP2[0].textContent = 'Nuevo Texto Classe';
    }

    console.log(textP3);
    textP3[2].textContent = 'Nuevo Texto Etiqueta';
};

function boton2() {
    let pAll = document.getElementsByTagName('p'); 
    
    pAll[0].classList.add('classeP');

    pAll[1].classList.remove('classeP');
    pAll[1].classList.add('classeP2');
}

function boton3() {
    let pAll = document.getElementsByTagName('p'); 

    for (let i = 0; i < pAll.length; i++) {
        if (pAll[i].className != "") {
            pAll[i].classList.remove(pAll[i].className);
        }
    }
}

function boton4() {
    location.reload();
}

function boton5() {
    medida = sizeLetra.value;
    if (medida == "petita") {
        modSizeLetra(7)
    }
    else if (medida == "mitjana") {
        modSizeLetra(14)
    }
    else if (medida == "gran") {
        modSizeLetra(30)
    }
}
function modSizeLetra(px = 12) {
    let pAll = document.getElementsByTagName('p'); 

    for (let i = 0; i < pAll.length; i++) {
        pAll[i].style.fontSize = px + "px";
    }
}

function boton6() {
    let newP = document.createElement('p');
    let contenP = document.getElementById('newText').value;

    newP.textContent = contenP;
    document.getElementById('main').appendChild(newP);

    var pAll = document.getElementsByTagName('p');

    for (i = 0; i < pAll.length - 1; i++) {
        idP = pAll[i].id.split('p');
        if (idP[1] == undefined) {
            pAll[i].id = 'p' + (i + 1);
        }
    }
}

function boton7() {
    var pAll = document.getElementsByTagName('p');
    if (pAll.length > 0) {
        var PrimP = pAll[0];
        PrimP.parentNode.removeChild(PrimP);

        if (pAll.length > 0) {
            var FinP = pAll[pAll.length - 1];
            FinP.parentNode.removeChild(FinP);
        }
    }
    else {
        alert('No hay parrafos a eliminar');
    }
}