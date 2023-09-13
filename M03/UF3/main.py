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
            
            
def leerInicialitzacions(ruta = '/inicialitzacions.txt'):
    """_
        lee inidicaciones
    """
    try:
        with open(ruta , 'r') as f:
            linies = f.readlines()
            
            leer_concur = linies[0].split(" ")
            concur = leer_concur[1].split("\n")
            
            intent = linies[0].split(" ")
            crearInformacion(ruta, int(concur[0]) , int(intent[1]))
                
    except:
        print("Ha surgido un error inesperado")

def crearInformacion(ruta = '/', numero = 0 , intent = 0):
    """_
        crea informacion
    """
    try:
        with open(rutaSola(ruta) + 'informacio.txt' , 'w') as f:
            f.write('NOM COGNOMS EDAT DNI POBLACIÓ\n')
            total_intentos = []
            for j in range(numero):
                total = ""
                total += pedir('Introduce NOM') + '|'
                total += pedir('Introduce COGNOMS') + '|'
                total += str(pedir('Introduce EDAT' , 'int')) + '|'
                dni = pedirDNI()
                total += dni + '|'
                total += pedir('Introduce POBLACIÓ')
                f.write(total + '\n')
                intentos = [dni]
                for m in range(intent):
                    intentos.append(pedir('Introduce puntuacion' , 'int'))
                
                total_intentos.append(intentos)
                
                print('--------------------------------------------------------')
            intentoImp(ruta , total_intentos)
                
                
    except:
        print("Error incesperado")
            
def intentoImp(ruta = '/' , intentos = []):
    """_
        escribe puntuacion
    """
    with open(rutaSola(ruta) + 'puntuacio.dat', 'wb') as g:
        pickle.dump(intentos, g)



def introRuta():
    """
        pide la ruta
    """
    print("Inserte la ruta de 'inicialitzacions.txt'")
    print("Ejemplo '/home/adaw/inicialitzacions.txt'")
    bucle = True
    while bucle:
        ruta = input("Introduce una ruta --> ")
        if verificacionRuta(ruta):
            print("Introduce una ruta valida")
        else:
            veri = ruta.split('/')
            if veri[len(veri) -1] == "inicialitzacions.txt":
                bucle = False
            else:
                print("El fichero especidicado no es valido")
    return ruta

def verificacionRuta(ruta):
    """
        veridica que la ruta sea valida
    """
    try:
        if os.path.isfile(ruta):
            return False
        else:
            return True
    except:
        return True

def rutaSola(ruta):
    """_
        saca la ruta
    """
    ruta_real_descom = ruta.split('/')
    ruta_real = ''
    for i in range(len(ruta_real_descom) -1):
        ruta_real += ruta_real_descom[i] + '/'
    
    return ruta_real

def pedirDNI():
    """_
        pide dni
    """
    bucle = True
    while bucle:
        dni_prev = pedir('Introduce DNI')
        dni_list = list(dni_prev)
        len_dni = len(dni_list)
        if len_dni == 9:
            prueba = True
            for i in range(len_dni):
                if i < 8:
                    try:
                        if dni_list[i] == int(dni_list[i]):
                            pass
                    except:
                        preuba = False
            if prueba:
                dni = "".join(dni_list)
                return dni
    
    
    
    



def main():
    #ejecuta
    ruta = introRuta()
    ruta_real = rutaSola(ruta)
    leerInicialitzacions(ruta)
    
    
    
    
if __name__ == '__main__':
    main()
    
    