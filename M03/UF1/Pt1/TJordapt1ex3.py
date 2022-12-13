import time
import math

pi = math.pi + 0

print("Selecione una de las opciones a continuación: \n" , "1. Calcular perimetro y area de un rectangulo \n" , "2. Calcular perimetro y area de un circulo \n")
time.sleep(0.5)
x = int(input("Indique la opcion elegida -->  "))

#======================

if x == 1:
    b = float(input("Indique la base -->  "))
    h = float(input("Indique la altura -->  "))
    
    print(f"El perimetro es: {(b*2) + (h*2)} \nLa area es: {b*h}")
    
elif x == 2:
    r = float(input("Indique el radio -->  "))
    
    print(f"El perimetro es: {2 * pi * r } \nLa area es: {pi * r**2}")
    
else:
    time.sleep(2)
    print("ERROR \nselecione una de las opciones indicadas")