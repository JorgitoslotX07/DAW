import os , math


def mensajeErrorNumero():
    print("Introduce un numero valido")

def pedirNumRango(min = -math.inf , max = math.inf):
    bucle = True
    while bucle:
        try:
            num = int(input("Intrduce un numero --> "))
            if num > max or num < min:
                mensajeErrorNumero()
            else:
                bucle = False
        except:
            mensajeErrorNumero()
    return num

def introRuta():
    bucle = True
    while bucle:
        ruta = input("Introduce una ruta --> ")
        if verificacionRuta(ruta):
            print("Introduce una ruta valida")
        else:
            bucle = False
    return ruta

def verificacionRuta(ruta):
    try:
        os.chdir(ruta)
        return False
    except:
        return True

def contarCarpetaFichero(carpeta):
    num_dir = 0
    num_file = 0
    for i in range(len(carpeta)):
        if os.path.isfile(carpeta[i]):
            num_file += 1
        elif os.path.isdir(carpeta[i]):
            num_dir += 1
    return [num_dir , num_file]


def borrarFile(carpeta):
    for i in range(len(carpeta)):
        if os.path.isfile(carpeta[i]):
            os.remove(carpeta[i])

def borrarDir(carpeta , ruta):
    for i in carpeta:
        ruta = os.path.join(ruta , i)
        if os.path.isdir(ruta):
            borrarTot(ruta)
            os.rmdir(ruta)
        
            
            
                
                


        
def menu():
    print("""
        1- Esborrar només els fitxers
        2- Esborrar només les carpetes
        3- Esborrar tot (fitxers i carpetes)
        4- No fer res
    """)
    num = pedirNumRango(1,4)
    return num


def main():
    ruta = introRuta()
    
    carpeta = os.listdir()
    print(carpeta)
    
    cantidad_dir_file = carpetaFichero(carpeta)
    print("Numeor de directorios -->" , cantidad_dir_file[0])
    print("Numeor de fixeros -->" , cantidad_dir_file[1])
    
    print()
    
    num = 0
    while num != 4:
        num = menu()
        
        
        
        
        
##### Programa ######
if __name__ == '__main__':
    ruta = introRuta()
    
    carpeta = os.listdir()
    print(carpeta)
    
    cantidad_dir_file = contarCarpetaFichero(carpeta)
    print("Numeor de directorios -->" , cantidad_dir_file[0])
    print("Numeor de fixeros -->" , cantidad_dir_file[1])
    
    print()
    
    num = 0
    while num not in (1,2,3,4):
        num = menu()
        if num == 1:
            borrarFile(carpeta)
        elif num == 2:
            borrarDir(carpeta)
        elif num == 3:
            pass
        else:
            mensajeErrorNumero()
            

  
