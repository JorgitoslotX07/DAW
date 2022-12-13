import random
# imprimir de que trata el programa
print("CRUCES SEGUIDAS")
# pedir numero de tiradas
tiradas = int(input("¿Cuántas veces sa va a tirar la moneda? "))
# comprovacion que hay como minimo 2 tiradas
if tiradas < 2:
    print("¡La moneda se debe tirar almenos dos veces!")
else:
    #imprimt inicio de las tiradas
    print("Tirada: " , end=(""))
    #imprimir que sale y calcular numeor de cruces obtenidas
    cruz = 0
    max_cruz = 0
    for num_tirada in range(tiradas):
        num = random.randint(1,2)
        if num == 1:
            print("\u2716" , end=(" "))
            cruz += 1
            if cruz > max_cruz:
                max_cruz = cruz
        else:
            print("\u26AA" , end=(" "))
            cruz = 0
    #imprimir resultado
    if max_cruz == 0:
        print("\nNo ha salio ninguna cruz.")
    elif max_cruz < 2:
        print("\nHa Salido alguna cruz, pero no han llegado a salir dos cruces seguidas.")
    else:
        print(f"\nSe han llegado a obtener {max_cruz} cruces seguidas")