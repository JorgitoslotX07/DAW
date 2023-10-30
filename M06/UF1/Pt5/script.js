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
            portatiles.push(portatil);
        }
    }

    // let portatilesString = localStorage.getItem('portatiles');
    // let portatiles = JSON.parse(portatilesString);

    console.log(portatiles);
    return portatiles;
}

function setPortatiles(portatil) {

    let key = localStorage.getItem('key') || 1;
    let portatilKey = "portatil" + key;

    localStorage.setItem(portatilKey, JSON.stringify(portatil));

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
    
    if (portatiles == null) {
        return null;
    }
    else {
        let ultimoPortatil = portatiles[portatiles.length - 1];
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