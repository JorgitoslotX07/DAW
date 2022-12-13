import time

x = int(input("Selecione una de las siguentes opciones: \n1. Pasar grados Fahrenheit a Celsius. \n2. Pasar grados Celsius a Fahrenheit.\n---->  "))

time.sleep(0.5)

if x == 1:
    f = float(input("Indique los grados Fahrenheit -->  "))
    c = (f - 32) * 5 / 9
    print(c , "grados Celsius")

elif x == 2:
    c = float(input("Indique los grados Celsius -->  "))
    f = 9 / 5 * c + 32
    print(f , "grados Fahrenheit")

else:
    print("¡¡ERROR!!\nSelecione uno de los paramentros mostrados")