function personatge(nom , cognoms , edat , data_naixement , adreca , interesos) {
    this.nom = nom;
    this.cognoms = cognoms;
    this.edat = edat;
    this.data_naixement = data_naixement;
    this.adreca = adreca;
    this.interesos = interesos;

    this.listar = function() {
        console.log(
            'Hola, le meu nom ès ' + this.nom + 
            ' ' + this.cognoms + ', tinc ' + this.edat + 
            ' anys, vaig neixer el ' + this.data_naixement + 
            ', visc al ' + this.adreca + " i m'agrada "
            + this.interesos +'.'

        );
    }
}

var personaje1 = new personatge(
    'Pep',
    'Figuerola',
    34,
    '1/1/1985',
    'C/La Figuera nº 1',
    'llegir novel·la romàntica i fer mitja'
);

var personaje2 = new personatge(
    'Toni',
    'Jordà León',
    19,
    '28/06/2004',
    'C/General Romagosa, 33',
    'hacer algo'
);

personaje1.listar();
personaje2.listar();