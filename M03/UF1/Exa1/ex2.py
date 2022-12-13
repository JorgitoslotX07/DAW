"""Escriviu un programa que demani tres números diferents, 
de manera que el segon sigui múltiple del primer i el tercer sigui 
divisor del segon. El programa avisarà l'usuari quan no es compleixin 
les condicions sol·licitades."""

print("PIDE NÚMEROS")

# Introducion de numero
x = int(input("Escriba un número entero positivo: "))

# Separacion de Positivos y negativos
if x >= 0:
    #Introducion de otro numero (multiplo)
    y = int(input(f"Escriba un múltiplo de {x}: "))
    # Filtro nuevo numero mayor que el enterior
    if y < x:
        print(f"¡El múltiplo debe ser mayor que {x}!")
    #Filtro no multiplos
    elif y % x != 0:
        print(f"¡{y} no es múltiplo de {x}!")
    else:
        #Introducion de otro numero (divisor)
        z = int(input(f"Escriba un divisor de {y} distinto de {x}: "))
        # Filtro nuevo numero igual que el enterior
        if z == x:
            print(f"¡Le he pedido un número distinto de {x}!")
        # Filtro nuevo numero menor que el enterior
        elif z > y:
            print(f"¡El divisor debe ser menor de {y}!")
        #Filtro no divisores        
        elif y % z != 0:
            print(f"¡{z} no es dividor de {y}!")
        
        else:
            print("¡Gracias por su colaboración!")
    
else:
    print("¡No ha escrito un número entero positivo!")
