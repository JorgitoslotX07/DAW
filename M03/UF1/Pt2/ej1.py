#Feu un programa que llegeixi un número sencer, i ens digui si és parell o senar.
import time

num = float(input("Introduce un numero -->  "))
par_o_senar = "PARELL" if (num % 2 == 0) else "SENAR"

time.sleep(0.5)

print(f"El numero introducido es {par_o_senar}")