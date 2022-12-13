whi = True
num_tot = []
while whi:
    num = int(input("Introduce un numero -->  "))
    if num > 0 and num < 100000:
        num_tot.append(num,)
    elif num == 0:
        whi = False
    elif num > 100000:
        print("El numero introducido es mayor que 100000")
    else:
        print("El numero introducido es negativo")
num_con = 0
rep_con = len(num_tot)
while num_con < rep_con:
    con = 1
    res1 = 0
    res_max = 0
    num = num_tot[num_con]
    while con <= num:
        con += 1
        num2 = con -1
        con2 = 0
        while num2 > 0:
            con2 += num2
            num2 -= 1
        num3 = con +1
        con3 = 0
        while num3 <= num:
            con3 += num3
            num3 += 1
            if con3 == con2:
                res1 += 1
                if con > res_max:
                    res_max = con
    if res1 == 0:
        print(num , "no hay")
    else:
        print(num , " " , res1 , " " , res_max)
    num_con += 1


__________________________________________________________________________________________________________________________________________________



# Introducion numero de repeticiones para los valores a introducir
num_ini = int(input("Introduce el numero de numeros a introducir -->  "))
whi = 0
# Acumulador de valores
num_tot = []
# Bucle a valores a introducir
while whi < num_ini:
    # Introduccion de valor
    num = int(input("Introduce un numero -->  "))
    # Verificacion de valor
    if num > 0 and num <= 100000:
        # Introducir valor al acumulador
        num_tot.append(num,)
        whi += num_ini
    elif num == 0:
        # Salir del bucle de manera forzosa
        whi = num_ini
    # Mensajes de error
    elif num > 100000:
        print("El numero introducido es mayor que 100000")
    else:
        print("El numero introducido es negativo")
# Contador valores a calucar
num_con = 0
# Cantidad de valores a evaluar
rep_con = len(num_tot)
#Calcular valores
while num_con < rep_con:
    #Introduccion variables para verificar NumerosCentrales
    con = 1
    res1 = 0
    res_max = 0
    # Asignacion de valor a evaluar, segun el lugar de la lista
    num = num_tot[num_con]
    # Repeticiones a evaluar
    while con <= num:
        con += 1 # Establecer NumeroCentral (NC)
        num2 = con -1 # Numero inmediatamente inferior a NC
        con2 = 0 #  suma numeros inferiores a NC
        # Calcular suma de numero inferiores a NC
        while num2 > 0:
            con2 += num2
            num2 -= 1
        num3 = con +1 # Numero inmediatamente superior a NC
        con3 = 0 #  suma numeros superiores a NC
        # Calcular suma de numero superiores a NC
        while num3 <= num:
            con3 += num3
            num3 += 1
            # Verificaion suma de numeros superiores a NC igual a suma numeros inferiores
            if con3 == con2:
                res1 += 1 # contar NC existentes
                # Guardar NC mayor
                if con > res_max:
                    res_max = con
    # Imprimir cantidad NC que hay
    if res1 == 0:
        print(num , "no hay")
    else:
        print(num , " " , res1 , " " , res_max)
    num_con += 1 # Pasar al siguiente numero lista

