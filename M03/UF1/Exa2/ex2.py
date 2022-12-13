#contadores
muert_A = 0
muert_R = 0
muert_tot = 0
#bucle para introducir muertos
salir = 0
while salir == 0:
    muert = int(input("Introduce el numero de humanos muertos: "))
    muert_tot = muert_tot + muert
    #decidir tipo de orco
    salir1 = 0
    while salir1 == 0: 
        tipo = str(input("Introduce el tipo de orco (Azul tipo A y Rojo tipo R): "))
        tipo = tipo.upper()
        if tipo == "A":
            muert_A = muert_A + muert
            salir1 = 1
        elif tipo == "R":
            muert_R = muert_R + muert
            salir1 = 1
        else:
            print("Introduce un tipo valido (A o R) ")
    #decidir si salir del bucle o continuar en el
    salir1 = 0
    while salir1 == 0:
        salir = str(input("Desea continuar? (si = y, no = n) "))
        if salir == "y":
            salir = 0
            salir1 = 1
        elif salir == "n":
            salir = 1
            salir1 = 1
        else:
            print("Introduce un valor valido (si = y, no = n) ")
#resultado
x100_A = (muert_A / muert_tot) * 100
x100_R = (muert_R / muert_tot) * 100
print(f"Media de muertes:\n \tMuertes totales: {muert_tot}\n \tAzules (Tipo A): {int(x100_A)}% ({muert_A} muertos)\n \tRojos (Tipo R): {int(x100_R)}% ({muert_R} muertos)")