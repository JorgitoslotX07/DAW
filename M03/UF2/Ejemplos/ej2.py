from numpy import Inf


lenguajes = []

nom = input("Introduce un lenguaje de programacion -->  ")
blanco = False
while not blanco:
    lenguajes.append(nom)
    nom = input("Introduce un lenguaje de programacion -->  ")
    if nom is None:
        blanco = True

lenguajes = tuple(lenguajes)

print(lenguajes)
print(f"Nº d'elements: {len(lenguajes)}")
a = "Ada95"
if a in lenguajes:
    print(f"{a} està a la tupla. Està en la posición: " , end="")
    for i in range(len(lenguajes)):
        if lenguajes[i] == a:
            print(i)
            a = Inf
            
