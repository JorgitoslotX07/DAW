"""

Un programa llegirà tres números per teclat. 
La sortida del programa serà treure per pantalla si 
l’usuari ha introduït aquests números per ordre de 
menor a major o no. p.ex. si l’usuari entra 1,4,6 
el programa dirà “números en ordre” si l’usuari 
entra 5,7,3 el programa dirà “números desordenats”

"""

import time

a = float(input("Introduce un numero -->  "))
b = float(input("Introduce otro numero -->  "))
c = float(input("Introduce un ultimo numero -->  "))

time.sleep(1)

if a < b < c:
    print("números en ordre")
else:
    print("números desordenats")