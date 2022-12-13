"""
Un instal·lador de xarxa cobra segons hores treballades i metres de cable instal·lats. Assumirem que el preu per hora són 30€ l’hora i el preu per metre del cable és 0,5€. Aquestes dues quantitats són fixes (CONSTANTS).
El programa ens haurà de demanar:
 • les hores treballades
 • el nombre de metres instal·lats
 • ens traurà per pantalla:
    el preu brut és ....
    el preu amb IVA és ....
"""

import time

preu_hora = 30
preu_metre_cable = 0.5

horas_trabajadas = float(input("Introduce las horas trabajadas -->  "))
metros_instalados = float(input("Introduce los metros de cable instaldas -->  "))

time.sleep(0.5)

precio_bruto = (horas_trabajadas * 30) + (metros_instalados * 0.5) 
precio_IVA = (precio_bruto * 0.21) + precio_bruto

print(f"-Precio bruto: {precio_bruto}€ \n-Precio con IVA: {precio_IVA}€")