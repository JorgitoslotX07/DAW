"""
 En una empresa necessiten un petit programa que permeti calcular l’import que han de pagar als treballadors. Els pagaments es fan de forma setmanal. Per a cada assalariat es recullen via teclat les següents dades:
 • Nombre d’hores setmanals treballades a la setmana
 • Preu per hora (és diferent per a cada treballador)
Es considera que un treballador comença a fer hores extres a partir de l'hora 35. Les hores extres es paguen un 50% més que les hores normals. El programa ha d’imprimir per pantalla l’import final, tenint en compte el preu/hora indicat i si hi ha hores extres o no.
"""

horas = float(input("Introduce las horas trabajadas -->  "))
precio_hora = float(input("Introduce el precio por hora -->  "))

if horas < 35:
    horas = horas - 35
    importe = (35 + [horas / 2]) * precio_hora
    print(f"Import final: {importe}€")
else:
    importe = horas * precio_hora
    print(f"Import final: {importe}€")