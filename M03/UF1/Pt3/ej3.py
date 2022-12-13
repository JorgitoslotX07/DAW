bacteria = int(input("Inserte una cantidad de bacterios -->  "))
minutos = 0
horas = 0
while bacteria < 10000000:
    bacteria = bacteria * 2
    minutos += 3
while minutos > 60:
    minutos -= 60
    horas += 1
if horas != 0 and minutos != 0:
    print(f"La cantidad mortal de bacterias se ha alcanzado en: {horas}h y {minutos}min") 
elif horas != 0:
    print(f"La cantidad mortal de bacterias se ha alcanzado en: {horas}h")
else: 
    print(f"La cantidad mortal de bacterias se ha alcanzado en: {minutos}min") 