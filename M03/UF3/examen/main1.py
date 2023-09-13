import os
import pickle
from main import pedir  , leerInicialSep 

def leerInventario():
    """
        Devuelve las lista dentro de 'invenrai.dat' dentro de otra lista
    """
    acaba = True
    lista = []
    try:
        with open('inventari.dat', 'rb') as g:
            while acaba:
                try:
                    lin = pickle.load(g)
                    lista.append(lin)
                except EOFError:
                    acaba = False
        return lista
    except:
        print("Error inesperado")
    
def verDentroIncial(para = 'SO'):
    """
        Devuelve un booleano dependiendo si el parametro especificado esta como 'SI'
        en los paramentros iniciales.
        Tambien devuelve la posicion
    """
    inicial = leerInicialSep()
    posi = 0
    for i in range(len(inicial)):
        if inicial[i][1] == 'SI' or inicial[i][1] == 'SI\n':
            if inicial[i][0] == para:
                return [True , posi]
            posi += 1
    return [False]

def contarPCinventario(pc = " " , posi = 0):
    """
        Envia el recuento de un eleento en x posicion dentro de un array
    """
    lista_inv = leerInventario()
    con = 0
    for i in lista_inv:
        if i[posi] == pc:
            con += 1
    return con

def main():
    # Ejecuta el programa principal
    para = 'SO'
    ver = verDentroIncial(para)
    if ver[0]:
        
        print(f"Hi ha {contarPCinventario('Windows 10' , ver[1])} ordinadores amb Windows 10")
    else:
        print(f"El {para} no esta inclos en l'inventari")
    
    
    
if __name__ == '__main__':
    main()
    
    