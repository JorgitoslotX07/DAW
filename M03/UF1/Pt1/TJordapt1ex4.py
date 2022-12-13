import time
import random

x = float(input("Ingrese la cantidad de dinero -->  "))
y = float(input("Indique una tasa de interes -->  "))
z = float(input("Indique la cantidad de años -->  "))

xyz = x * (1 + y/100) **z


n = 1
n2 = random.randint(3,15)

time.sleep(1.5)

while n < n2:
    print(f"PROCESANDO... {n}")
    time.sleep(0.5)
    n = n + 1

time.sleep(1)
print(xyz)