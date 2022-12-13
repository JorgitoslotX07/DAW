#Indica en cadascun dels següents programes quins valors en les respectives entrades provoquen l’aparició dels diferents missatges.
"""
#misteri1.py 
letra = input("Dame una letra minúsciula: ")
if letra <= "k":
    print("Es de les primeras del alfabeto")
if letra >= "l":
    print("Es de les ultimes del alfabeto")
"""
# En mistery1.py muestra el primer mensaje siempre que el caracter introducido este antes que la letra 'k', el el sistema ASCII, al rebes con el otro mensaje.
"""      
#mistery2.py
from math import ceil
# ceil redondea al alza
grados = float (input("Dame unb angulo (en grados): "))

cuadrante = int (ceil (grados) %360) / 90

if cuadrante == 0:
    print("primer cuadrante")
if cuadrante == 1:
    print("segundo cuadrante")
if cuadrante == 2:
    print("tercer cuadrante")
if cuadrante == 3:
    print("cuarto cuadrante")
"""
# cuadrante devuelve numeros en decimal, por lo que solo mostrara los mensajes simepre que se introducan los siguienes numeros(0 (primer), 90 (segundo), 180 (tercero), 270(cuarto))