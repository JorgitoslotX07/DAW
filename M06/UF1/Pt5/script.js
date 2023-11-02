function Portatil(marca, modelo, modeloCPU, ram, 
    tipoDiscoDuro, capacidadDiscoDuro, pantalla) {
        this.marca = marca,
        this.modelo = modelo,
        this.modeloCPU = modeloCPU,
        this.ram = ram,
        this.tipoDiscoDuro = tipoDiscoDuro,
        this.capacidadDiscoDuro = capacidadDiscoDuro,
        this.pantalla = pantalla
}

function getPortatiles() {
    let portatiles = [];
    for (let i = 0; i < localStorage.length; i++) {
        let key = localStorage.key(i);
        if (key.startsWith("portatil")) {
            let portatilString = localStorage.getItem(key);
            let portatil = JSON.parse(portatilString);
            portatiles.push(
                {
                    key: key,
                    portatil: portatil
                }
            );
        }
    }

    // Ordenar portatiles
    portatiles.sort((a, b) => {
        let keyA = parseInt(a.key.replace('portatil', ''), 10);
        let keyB = parseInt(b.key.replace('portatil', ''), 10);
        return keyA - keyB;
    });


    // let portatilesString = localStorage.getItem('portatiles');
    // let portatiles = JSON.parse(portatilesString);

    console.log(portatiles);
    return portatiles;
}

function setPortatiles(por) {

    let key = localStorage.getItem('key') || 1;
    let portatilKey = "portatil" + key;

    localStorage.setItem(portatilKey, JSON.stringify(por));

    key++;
    localStorage.setItem('key', key);

    // let portatiles = this.getPortatiles();

    // if (portatiles == null) {
    //     portatiles = [];
    // }

    // portatiles.push(portatil);

    // //console.log(portatiles);
    // localStorage.setItem('portatiles', 
    //     JSON.stringify(portatiles));
}


function guardarPortatil() {

    let marca = document.getElementById('marca').value;
    console.log(marca);
    let modelo = document.getElementById('modelo').value;
    let modeloCPU = document.getElementById('modeloCPU').value;
    let ram = document.getElementById('ram').value;
    let tipoDiscoDuro = document.getElementById('tipoDiscoDuro').value;
    let capacidadDiscoDuro = document.getElementById('capacidadDiscoDuro').value;
    let pantalla = document.getElementById('pantalla').value;

    let portatil = new Portatil (marca, modelo, modeloCPU,
        ram, tipoDiscoDuro, capacidadDiscoDuro, pantalla);
    
    this.setPortatiles(portatil);

    onLoad();
}   


function valueUltimoPortatil() {

    let portatil = ultimoPortatil();
    if (portatil) {
        valueForm(
            portatil['marca'],
            portatil['modelo'],
            portatil['modeloCPU'],
            portatil['ram'],
            portatil['tipoDiscoDuro'],
            portatil['capacidadDiscoDuro'],
            portatil['pantalla']
        );
    }
    else {
        valueForm()
    }
}

function valueForm(marca = null, modelo = null, modeloCPU = null, ram = null, 
    tipoDiscoDuro = null, capacidadDiscoDuro = null, pantalla = null) {
    document.getElementById('marca').value = marca;
    document.getElementById('modelo').value = modelo;
    document.getElementById('modeloCPU').value = modeloCPU;
    document.getElementById('ram').value = ram;
    document.getElementById('tipoDiscoDuro').value = tipoDiscoDuro;
    document.getElementById('capacidadDiscoDuro').value = capacidadDiscoDuro;
    document.getElementById('pantalla').value = pantalla;
}

function ultimoPortatil() {
    let portatiles = getPortatiles();
    
    if (portatiles == null || portatiles.length == 0) {
        return null;
    }
    else {
        let ultimoPortatil = portatiles
            [portatiles.length - 1]['portatil'];
        return ultimoPortatil;  
    }
}


function numeroPortatiles() {
    let numPortatiles = getPortatiles();

    document.getElementById('numPortail').textContent = 'Nº Poratiltes: ' + 
        (numPortatiles != null ? numPortatiles.length : 0);
}

function onLoad() {
    valueUltimoPortatil();
    numeroPortatiles()
}

function reiniciarPortatiles() {
    localStorage.clear();

    onLoad();
}

function get2PortatilesAleatorios() {
    let portatiles = getPortatiles();
    let numeros = get2NumerosAleatorios(portatiles.length - 1);
    
    return {
        port1: portatiles[numeros[0]],
        port2: portatiles[numeros[1]]
    }
}

function get2NumerosAleatorios(max) {
    let num1 = getNumeroAleatorio(max);
    let num2 = num1;

    while (num2 == num1) {
        num2 = getNumeroAleatorio(max);
    }

    return [num1, num2];
}

function getNumeroAleatorio(max){
    let num = Math.floor(Math.random() * max) + 1;
    return num;
}

function tablaPortatiles() {
    
    let ports = get2PortatilesAleatorios();

    let port1 = ports.port1.portatil;
    let port2 = ports.port2.portatil;
    let keys = Object.keys(ports.port1.portatil)


    // let ventanaEmergente = window.open('', 
    //     '_blank', 'width=400,height=400');
    let tabla = document.createElement('table');
    let fila1 = tabla.insertRow();
    let fila2 = tabla.insertRow();
    let fila3 = tabla.insertRow();

    // Poner keys en tabla
    // keys.forEach(e => {
    //     fila1.insertCell().textContent = e;
    // });
    introducirFila(keys, fila1);

    console.log(port1)
    // Poner keys en tabla
    // port1.forEach(e => {
    //     fila2.insertCell().textContent = e;
    // });
    introducirPortatilFila(port1, fila2);

    // Poner keys en tabla
    // port2.forEach(e => {
    //     fila3.insertCell().textContent = e;
    // });
    introducirPortatilFila(port1, fila3);
    
    document.body.appendChild(tabla);
}

function introducirPortatilFila(port, fila) {
    list = [];
    for (let key in port) {
        list.push(port[key]);
    }

    introducirFila(list, fila);
}

function introducirFila(list, fila) {
    list.forEach(e => {
        fila.insertCell().textContent = e;
    });
}