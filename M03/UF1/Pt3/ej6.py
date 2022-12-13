cant_num = int(input("introduce la cantidad de numeros que va a introducir -->  "))
media = 0
con = 0
while con < cant_num:
    con += 1
    num = float(input("Introduce un numero -->  "))
    media += num
    if con == 1:
        num_min = num
        num_max = num
    if num < num_min:
        num_min = num
    if num > num_max:
        num_max = num
print(f"La media es de: {media}\nEl numero maximo es: {num_max}\nY el minimo es: {num_min}")