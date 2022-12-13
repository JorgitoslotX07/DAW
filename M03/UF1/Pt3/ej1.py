import time 
import os
import platform

sistema = platform.system()
x = 1

if sistema == "Windows":
    while x != 0:
        x = int(input("CALCULADORA\nMenu Principal\n\n1 - Sumar\n2 - Restar\n3 - Multiplicar|n3 - Dividir\n0- Sortir\n\nOpció: "))
        time.sleep(0.3)
        if x == 1:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            time.sleep(0.5)
            print("La suma es: " , num1 + num2)
            supr = input("")
            if supr != "℗":
                os.system ("clr")
        elif x == 2:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            time.sleep(0.5)
            print("La resta es: " , num1 - num2)
            supr = input("")
            if supr != "℗":
                os.system ("clr")
        elif x == 3:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            time.sleep(0.5)
            print("El producte es: " , num1 % num2)
            supr = input("")
            if supr != "℗":
                os.system ("clr")
        elif x == 4:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            if num2 == 0:
                print("¡¡ERROR!! El segon numero no pot ser 0.")
            time.sleep(0.5)
            print("La producto es: " , num1 / num2)
            supr = input("")
            if supr != "℗":
                os.system ("clr")
        elif x > 4:
            print("¡¡ERROR!! Introdueix un del numeros del menu.")
        else:
            break   
else:
    while x != 0:
        x = int(input("CALCULADORA\nMenu Principal\n\n1 - Sumar\n2 - Restar\n3 - Multiplicar|n3 - Dividir\n0- - Sortir\n\nOpció: "))
        time.sleep(0.3)
        if x == 1:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            time.sleep(0.5)
            print("La suma es: " , num1 + num2)
            supr = input("")
            if supr != "℗":
                os.system ("clear")
        elif x == 2:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            time.sleep(0.5)
            print("La resta es: " , num1 - num2)
            supr = input("")
            if supr != "℗":
                os.system ("clear")
        elif x == 3:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            time.sleep(0.5)
            print("El producte es: " , num1 % num2)
            supr = input("")
            if supr != "℗":
                os.system ("clear")
        elif x == 4:
            num1 = int(input("Escriu un numero: "))
            num2 = int(input("Escriu un altre numero: "))
            if num2 == 0:
                print("¡¡ERROR!! El segon numero no pot ser 0.")
            time.sleep(0.5)
            print("La producto es: " , num1 / num2)
            supr = input("")
            if supr != "℗":
                os.system ("clear")
        elif x > 4:
            print("¡¡ERROR!! Introdueix un del numeros del menu.")
        else:
            break