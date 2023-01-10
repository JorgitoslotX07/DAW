semana = ("Dilluns" , "Dimarts" , "Dimecres" , "Dijous" , "Divendres" , "Dissabte" , "Diumenge")
nom = input("Introduce tu nombre -->  ")

def inicial():
    separar[0] = separar[0].upper()
    juntar =  "".join(map(str,separar))
    return juntar
separar = list(nom)
nom = inicial()

for i in range(len(semana)):
    preg = input(f"{nom}, què faràs {semana[i].lower()}?")
    
    separar = list(preg)
    preg = inicial()
    
    print(f"El {semana[i].lower()} {nom} darà: {preg}")
