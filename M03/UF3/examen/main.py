import os
import pickle


def pedir(texto = "Introduce un numero" , tipo = "str"):
    """
        pide al usuario insertar texto, con opciones de cada tipo de dato y con texto personalizado
    """
    texto += ' --> '
    bucle = True
    while bucle:
        try:
            if tipo == 'bool':
                num = bool(input(texto))
            elif tipo == 'int':
                num = int(input(texto))
            elif tipo == 'float':
                num = float(input(texto))
            else:
                num = input(texto)
            return num
        except ValueError:
            print(f"ERROR, Introduce un valor valido :P ({tipo})")
                       
def leerInicialitzacions(ret = False):
    """
        Lee las indicaciones, devolbiendolas o como lista o imprimiendos directamente
    """
    try:
        with open('inicialitzacions.txt', 'r') as f:
            linies = f.readlines()
            if ret:
                return linies
            else:
                print("Parametros iniciales:")
                for i in linies:
                    lin = i.split('\n')
                    print(lin[0])                
    except:
        print("Ha surgido un error inesperado")
def leerInicialSep():
    """
        devuelve las lineas de la funcion 'leerIncialitzacions' separando los atributos
        por los espacios en blanco
    """
    lineas = leerInicialitzacions(ret = True)
    for i in range(len(lineas)):
        lineas[i] = lineas[i].split(' ')
    
    return lineas
       
def cambiosInicial():
    """
        Pregunta si desea realizar cambios en los paramentrode iniciales y si es asi
        pregunta cuales cambiar
    """
    cambios = pedir("Desea cambiar los parametros? (SI/NO)")
    if cambios.upper() == 'SI':
        lineas = leerInicialSep()
        cam = True
        print("Que parametro desea cambiar?")
        while cam:
            leerInicialitzacions()
            p = pedir("")
            comprov = False
            for i in range(len(lineas)):
                if lineas[i][0] == p.upper():
                    comprov = True
                    if lineas[i][1] == 'SI\n':
                        lineas[i][1] = 'NO\n'
                    elif lineas[i][1] == 'SI':
                        lineas[i][1] = 'NO'
                    elif lineas[i][1] == 'NO\n':
                        lineas[i][1] = 'SI\n'
                    elif lineas[i][1] == 'NO':
                        lineas[i][1] = 'SI'
            if not comprov:
                print("Introduce una opcion valida")
            impCambiosInicial(lineas)
            conti = pedir("Desea continuar? (SI/NO)")
            if conti.upper() != 'SI':
                cam = False
  
def impCambiosInicial(lineas= [[]]):
    """
        Reescribe el fichro inial segun los cambios enviardos por un array
    """
    try:       
        with open('inicialitzacions.txt', 'w') as f:
            for i in lineas:
                w = " ".join(i)
                f.write(w)              
    except:
        print("Ha surgido un error inesperado")
         
def invenImp(datos = []):
    """
        Insertar los datos introducidos en el inverntario (formato binario)
    """
    with open('inventari.dat', 'ab') as g:
        pickle.dump(datos, g)
def genInven():
    """
        Genera el usuario de 0 para no causar interferencias con los datos anteriores
    """
    with open('inventari.dat', 'wb') as g:
        pass

def insertInven():
    """
        pregunta constantemente los datos a introducir en el inventarios, segun los
        parametros iniciales
    """
    insertar = True
    lineas = leerInicialSep()
    genInven()
    while insertar:
        print("----------------------------------------")
        datos = []
        for i in lineas:
            if i[1] == 'SI\n' or i[1] == 'SI':
                if i[0] == 'CODI':
                    p = pedir("Ingresa " + i[0] , 'int')
                else:
                    p = pedir("Ingresa " + i[0])
                datos.append(p)
        
        invenImp(datos)
        
        conti = pedir("Desea continuar? (SI/NO)")
        if conti.upper() != 'SI':
            insertar = False

def main():
    #ejecuta
    leerInicialitzacions()
    print("----------------------------------------")
    cambiosInicial()
    insertInven()
    
    
    
if __name__ == '__main__':
    main()
    
    