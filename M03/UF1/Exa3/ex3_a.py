import random

# imprimir definicion programa
print("SUMAR Y GANAR\nVaya sumando todos los números que le iré diciendo.\nEmpezamos por 0.")
con_num = 0
bucle = 0
# comienzo bucle
while bucle >= 0:
    # calculo
    num = random.randint(0,50)
    con_num += num
    intro_num = int(input(f"Más {num}: "))
    if con_num == intro_num:
        bucle += 1
    # imprimir resultado final
    else:
        if bucle == 0:
            print("¿Has entendido el juego?")
        elif bucle == 1:
            print("¡Repase las sumas antes de jugar!")
        else:
            print(f"¡Ha acertado {bucle} veces seguidas!")
        bucle = -1