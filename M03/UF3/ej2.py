import os


# Zona libreria

def introRuta():
    bucle = True
    while bucle:
        ruta = input("Introduce una ruta --> ")
        if verificacionRuta(ruta):
            print("Introduce una ruta valida")
        else:
            ruta = verificacionFinalRuta(ruta)
            bucle = False
    return ruta

def verificacionRuta(ruta):
    try:
        os.chdir(ruta)   
        return False
    except:
        return True

def verificacionFinalRuta(ruta):
    ruta_veri = ruta.split(sep=os.sep)
    for i in range(len(ruta_veri)):
        if len(ruta_veri) - 1 == i and ruta_veri[i] != '':
            ruta += os.sep
    return ruta
 
def pedir(texto = "Introduce un numero" , tipo = "str"):
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

def pedirNota(asig = ""):
    texto = "Introduce nota " + asig
    nota = -1
    while nota > 10 or nota < 0:
        nota = pedir(texto , 'int')
        if nota > 10 or nota < 0:
            print("La nota no puede ser mayor a 10 o menor a 0")
    return nota
        


# Zona apartados 
    
def apa1():
    ruta = introRuta()
    
    fix_notas = open(ruta + 'notes.txt' , 'w')
    fix_notas.write('NOM COGNOM M1 M2 M3 M4 M5 M6 M7 M8 M9 M10 M11' + os.linesep)
    fix_notas.close()
    
    n_alum = pedir("Introduce numero de alumnos" , 'int')
    
    fix_notas = open(ruta + 'notes.txt' , 'r')
    primera_linea = fix_notas.readline()
    fix_notas.close()
    
    primera = primera_linea.split(sep=" ")
    con = 0
    bu = True
    while bu:
        if primera[con] == 'M1':
            bu = False
        else:
            con += 1
        
    n_primera = len(primera)
    fix_notas = open(ruta + 'notes.txt' , 'a')
    for i in range(n_alum):
        x = ''
        for j in range(n_primera):
            if j < con:
                x += pedir(f'Introduce {primera[j]}')
            else:
                nota = pedirNota(asig = primera[j])
                x += str()
            
            if j < n_primera:
                x += " "
            
        fix_notas.write(x + os.linesep)
# Ejecucion del programa

def main():
    apa1()




if __name__ == '__main__':
    main()
