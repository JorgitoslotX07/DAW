import math , time # Importar

# Crear lista para guardar temperaturas
list_tem = []

# Pedir temperaturas, validarlas y guardarlas
for i in range(10):
    bucle = True
    while bucle:
        tem = float(input(f"Introduca la temperatura maxima del dia ({i + 1}) --> "))
        if tem >= -50 and tem <= 50:
            list_tem.append(tem)
            bucle = False
        else:
            print("ERROR, debe introducir un numero entre los siquientes valores:\n\t- 50\n\t- -50")

# Salto de tiempo
time.sleep(0.5)

# Calcular madia, maxima y miniam de las temperaturas
if len(list_tem) != 0:
    max = -math.inf
    min = math.inf  
    
    con = 0
    for i in range(len(list_tem)):
        con += list_tem[i]
        if list_tem[i] > max:
            max = list_tem[i]
        if list_tem[i] < min:
            min = list_tem[i]
        
    media = con / len(list_tem)
    
    print(f"Tempreaturas:\n{list_tem}")
    print(f"Temperatura maxima --> {max}")
    print(f"Temperatura minima --> {min}")
    print(f"Temperatura media --> {round(media, 2)}")
else:
    print(f"Tempreaturas:\n{list_tem}")
    print(f"Temperatura maxima --> 0")
    print(f"Temperatura minima --> 0")
    print(f"Temperatura media --> 0, 2")
    
# Salto de tiempo
time.sleep(1)

# Pedir temperaturas, validarlas y guardarlas
for i in range(2):
    bucle = True
    while bucle:
        tem = float(input(f"Introduca la temperatura maxima del dia ({i + 1}) --> "))
        if tem >= -50 and tem <= 50:
            if i == 0:
                list_tem.insert(0, tem)
            else:
                list_tem.append(tem)
            bucle = False
        else:
            print("ERROR, debe introducir un numero entre los siquientes valores:\n\t- 50\n\t- -50")

# Salto de tiempo
time.sleep(0.5)

# Calcular madia, maxima y miniam de las temperaturas
if len(list_tem) != 0:
    max = -math.inf
    min = math.inf  
    
    con = 0
    for i in range(len(list_tem)):
        con += list_tem[i]
        if list_tem[i] > max:
            max = list_tem[i]
        if list_tem[i] < min:
            min = list_tem[i]
        
    media = con / len(list_tem)
    
    print(f"Tempreaturas:\n{list_tem}")
    print(f"Temperatura maxima --> {max}")
    print(f"Temperatura minima --> {min}")
    print(f"Temperatura media --> {round(media, 2)}")
else:
    print(f"Tempreaturas:\n{list_tem}")
    print(f"Temperatura maxima --> 0")
    print(f"Temperatura minima --> 0")
    print(f"Temperatura media --> 0, 2")
    
# Salto de tiempo
time.sleep(1)

# Pedir ubicacion de la lista de temperatuas
bucle = True
while bucle:
    ubi = int(input(f"Indique una posicion de la a anterior lista mostrada: \n\t-Min: 0\n\t-Max: {len(list_tem) - 1}\n--> "))
    if ubi < len(list_tem) and ubi >= 0:
        bucle = False
    else:
        print(f"ERROR, debe introducir un numero entre el rango mostrado anteriormente\n\t-Min: 0\n\t-Max: {len(list_tem) - 1}")

# Sustituir la temperatura anteriormente selecionada 
bucle = True
while bucle:
    tem = float(input(f"Introduca la temperatura maxima del dia --> "))
    if tem >= -50 and tem <= 50:
        list_tem[ubi] = tem
        bucle = False
    else:
        print("ERROR, debe introducir un numero entre los siquientes valores:\n\t- 50\n\t- -50")      
        
# Salto de tiempo       
time.sleep(0.5)

# Calcular madia, maxima y miniam de las temperaturas
if len(list_tem) != 0:
    max = -math.inf
    min = math.inf  
    
    con = 0
    for i in range(len(list_tem)):
        con += list_tem[i]
        if list_tem[i] > max:
            max = list_tem[i]
        if list_tem[i] < min:
            min = list_tem[i]
        
    media = con / len(list_tem)
    
    print(f"Tempreaturas:\n{list_tem}")
    print(f"Temperatura maxima --> {max}")
    print(f"Temperatura minima --> {min}")
    print(f"Temperatura media --> {round(media, 2)}")
else:
    print(f"Tempreaturas:\n{list_tem}")
    print(f"Temperatura maxima --> 0")
    print(f"Temperatura minima --> 0")
    print(f"Temperatura media --> 0, 2")
    
# Salto de tiempo
time.sleep(1)


print("Eliminando temperaturas inferiores de 30ºC" , end="")

# Eliminar tempetaruas por debajo de 30ºC y guardarlas en otra lista
calides = list_tem.copy()
con = 0
for i in range(len(calides) - 1 , - 1 , - 1):
    if con < 2:
        print("." , end="")
    elif con == 2:
        print(".")
    if calides[i] < 30:
        del calides[i]
    con += 1
 
# Salto de tiempo       
time.sleep(1.5)

# Calcular madia, maxima y miniam de las temperaturas
if len(calides) != 0:
    max = -math.inf
    min = math.inf  
    
    con = 0
    for i in range(len(calides)):
        con += calides[i]
        if calides[i] > max:
            max = calides[i]
        if calides[i] < min:
            min = calides[i]
        
    media = con / len(calides)
    
    print(f"Tempreaturas:\n{calides}")
    print(f"Temperatura maxima --> {max}")
    print(f"Temperatura minima --> {min}")
    print(f"Temperatura media --> {round(media, 2)}")
else:
    print(f"Tempreaturas:\n{calides}")
    print(f"Temperatura maxima --> 0")
    print(f"Temperatura minima --> 0")
    print(f"Temperatura media --> 0, 2")

# Salto de tiempo
time.sleep(1)

# Crear dicionarios y listas
dic = {}
temperades = []
fredes = []

# Separar la lista de temperatuas en en templadas y frias
for i in range(len(list_tem)):
    if list_tem[i] >= 15 and list_tem[i] <= 30:
        temperades.append(list_tem[i])
    elif list_tem[i] < 15:
        fredes.append(list_tem[i])   

print('Calides: ' , calides)
print('Temperades: ' , temperades)
print('Fredes: ' , fredes)

# Introducir las listas 'Calidas','Templades','Fredes' en el diccionario 'dic'
dic.setdefault('Calides', calides)
dic.setdefault('Temperades', temperades)
dic.setdefault('Fredes', fredes)

# Guardar en 2 listas la 'key' del diccionario y su respectiva lista
dies = 0
list_dia = []
list_key = []
for key in dic:
    dies += len(dic[key])
    list_dia.append(len(dic[key]))
    list_key.append(key)

# Salto de tiempo    
time.sleep(0.6)

# Printar la lista los 3 tipos de temperatuas en porcentaje (%) y con solo 2 decimales
print('Dies totals: ', dies)
for i in range(len(list_dia)):
    print(list_key[i] , '--> ', "{:.2f}".format(list_dia[i] * 100 / dies) , '%')

# Salto de tiempo
time.sleep(0.3)

# Pedir que introduza un tipo de temparatura
bucle = True
while bucle:
    ctf = input("Indique cual de los anteriores porcentajes desa visualizar  (Calides|Temperades|Fredes)--> ")
    #Comprobar si las letras coinciden, aparte de convertir todas las letras a minuscula
    ctf = ctf.lower()
    if ctf == 'calides' or ctf == 'temperades' or ctf == 'fredes':
        bucle = False
    else:
        print("ERROR, debe introducir uno de los valores señalados")

# Salto de tiempo
time.sleep(1)

# Convertir la primera letra en mayuscula y printar su lista
mayus = list(ctf)
mayus[0] = mayus[0].upper()
ctf = "".join(map(str, mayus))

print("Dias" , ctf , ': ' , len(dic[ctf]))

# Salto de tiempo
time.sleep(0.5)

# Calcular madia, maxima y miniam de las temperaturas
if len(dic[ctf]) != 0:
    max = -math.inf
    min = math.inf  
    
    con = 0
    for i in range(len(dic[ctf])):
        con += dic[ctf][i]
        if dic[ctf][i] > max:
            max = dic[ctf][i]
        if dic[ctf][i] < min:
            min = dic[ctf][i]
        
    media = con / len(dic[ctf])
    
    print(f"Tempreaturas:\n{dic[ctf]}")
    print(f"Temperatura maxima --> {max}")
    print(f"Temperatura minima --> {min}")
    print(f"Temperatura media --> {round(media, 2)}")
else:
    print(f"Tempreaturas:\n{dic[ctf]}")
    print(f"Temperatura maxima --> 0")
    print(f"Temperatura minima --> 0")
    print(f"Temperatura media --> 0, 2")
