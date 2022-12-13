import random
# imprimir de que trata el programa
print("JUEGO DE DADOS")
# padir turnos a jugar
turno = int(input("¿Cuántos turnos va a tener la partida? "))
print("\n")
#comprovacion turnos más de 1
if turno < 1:
    print("¡La partida debe tener almenos un turno!")
#juego
else:
    humerus = 0
    cubitus = 0
    #comienxo del jego
    for num_turno in range(turno):
        #imprimir en que turno estamos
        print(f"Turno {num_turno + 1}")
        con_humerus = 0
        con_cubitus = 0
        #calculo de los 4 dados tirados + si alguno coincide con dado
        for num_dado in range(7):
            dado = random.randint(1,6)
            if num_dado == 0:
                print("Tirada de Cubitus:" , end=(" "))
            elif num_dado == 4:
                print(f"=> {con_cubitus} puntos\nTirada de Humerus:" , end=(" "))
            
            if num_dado < 4:
                print(dado , end=(" "))
                if dado % 2 != 0:
                    con_cubitus += dado
            else:
                print(dado , end=(" "))
                if dado % 2 == 0:
                    con_humerus += dado
        print(f"  => {con_humerus} puntos\n")
        if con_humerus < con_cubitus:
            cubitus += 1
        elif con_humerus > con_cubitus:
            humerus += 1
    #imprimir resultado
    if humerus == cubitus:
        print(f"Han empatado (a {humerus})")
    elif humerus > cubitus:
        print(f"Ha ganado Humerus ({humerus} a {cubitus})")
    else:
        print(f"Ha ganado Cubitus ({cubitus} a {humerus})")