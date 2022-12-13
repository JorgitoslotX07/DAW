# imprimir de que trata el programa
print("CONVERTIDOR DE KILOGRAMOS EN LOTS, FUNTS, PUDS, BERKOBETS")
#pedir kg
kg = float(input("Escriba una cantidad de kilogramos: "))
#comprobar si los datos introducidos con validos
if kg < 0:
    print("Por favor, escriba un número positivo.")
#calcular los datos introducidos
else:
    g = kg * 1000
    lot = 12.7974
    
    con_funt = 0
    con_pud = 0
    con_berkovet = 0
    
    con_lot = g / lot
    
    while con_lot >= 32:
        con_funt += 1
        con_lot -= 32
    while con_funt >= 40:
        con_pud += 1
        con_funt -= 40
    while con_pud >= 10:
        con_berkovet += 1
        con_pud -= 10
    #redondear decimales
    lot = "{:.1f}".format(con_lot)
    #imprirmir resultado
    print(f"{kg} kg con {con_berkovet} berkovets, {con_pud} puds, {con_funt} funts y {lot} lots.")
    
    """
    con_lot = g / 12.7974
    if con_lot > 32:
        con_funt = con_lot // 32
        con_lot -= con_funt * 32
        if con_funt > 40:
            con_pud = con_funt // 40
            con_funt -= con_pud * 40
            if con_pud > 10:
                con_berkovet = con_pud // 10
                con_pud -= con_berkovet * 10
    lot = "{:.1f}".format(con_lot)
    print(f"{kg} kg con {int(con_berkovet)} berkovets, {int(con_pud)} puds, {int(con_funt)} funts y {int(lot)} lots.")
    """
