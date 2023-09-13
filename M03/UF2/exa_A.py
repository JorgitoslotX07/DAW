
def introBasura():
    basura = input("Inserta el nombre de la basura -->  ")
    basura = basura.lower()
    return basura

def introContenedor(contenedores):
    tipo_conten = ""
    for key in contenedores:
        tipo_conten += key + ", "
    
    bucle = True
    while bucle:
        contenedor = input(f"Color de contenedor ({tipo_conten}) -->  ")
        contenedor = contenedor.lower()
        for key in contenedores:
            if contenedor == key: 
                bucle = False
        if bucle:
            print("Contenedor incorrecto")
    return contenedor

def basuraContenedor(contenedores , tipo = 1):
    basura = "hola"
    while basura != "":   
        basura = introBasura()
        if basura != "":
            contenedor = introContenedor(contenedores)
            tipoBasuraContenedor(contenedores , basura , contenedor , tipo)
            
    return
def tipoBasuraContenedor(contenedores , basura , contenedor , tipo):
    if tipo == 1:
        for key in contenedores:
            if contenedor == key:
                contenedores[key].append(basura)
    elif tipo == 2:
        existe = False
        for key in contenedores:
            if basura in contenedores[key]:
                existe = True
                         
        if existe:
            cambio = contenedores.copy()
            veces = 0
            for key in contenedores:
                if basura in contenedores[key]:
                    cambio.setdefault(key , cambioContenedor(contenedores[key] , basura))
                    veces += 1
            cambio.setdefault(contenedor , cambioContenedor(contenedores[contenedor] , basura , veces))
        
        else:
            print(f"{basura} no esta en ningun contenedor")   
def cambioContenedor(contenedores , basura , veces = 0):
    if veces != 0:
        for i in range(veces):
            contenedores.append(basura)
    else:
        for i in range(len(contenedores) -1, -1, -1):
            if basura == contenedores[i]:
                del contenedores[i]
    return contenedores

def preguntarCambioContenedor(contenedores):
    cambio = input("Desesa cambiar alguna basura de contenedor? (Si/No) -->  ")
    if cambio.lower() == 'si':
        basuraContenedor(contenedores , 2)
    return        
        
def mostrarContenedores(contenedores , tipo = 0):
    print("Interior contenedores:")
    for key in contenedores:
        print(key, ':' , end=" ")
        veces = len(contenedores[key])
        if veces != 0:
            for i in range(veces):
                if i + 1 == veces:
                    print(contenedores[key][i] , end=" ")
                else:
                    print(contenedores[key][i] , end=", ")
        
        if tipo == 1:
            extraMostrarContenedores(contenedores[key] , 1)
            extraMostrarContenedores(contenedores , 2 , contenedores[key])
        print("")
def extraMostrarContenedores(contenedores , tipo , exCon = []):
    if tipo == 1:
        print("\tNª " , len(contenedores) , end=" ")
    elif tipo == 2:
        total = 0
        for key in contenedores:
            total += len(contenedores[key])
        print("\t{:.2f}".format(len(exCon) * 100 / total) , '% total' , end="")
        
    
    
            

"""
    CODIGO
"""

if __name__ == '__main__':
    contenedores = {"blau" : [] , "verd" : [] , "groc" : [] , "marro" : [] , "gris" : []}

    basuraContenedor(contenedores)
    mostrarContenedores(contenedores)

    preguntarCambioContenedor(contenedores)

    mostrarContenedores(contenedores , 1)


