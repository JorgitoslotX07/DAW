while True:
    # Introduccion de datos, base y exponente
    a = int(input("Introduce la base de la operacion (numero entero)-->  "))
    b = int(input("Introduce el exponente de la operacion (numero entero)-->  "))
    # Validez de numero, no pueden ser negativos
    if a > 0 and b > 0:
        break
    else:
        print("La base y el exponente tienen que ser positovos")
# Calculos para identificar el resultado
a2 = a
while b != 1:
    b -= 1
    a *= a2
#Imprimir resultado
print(a)
