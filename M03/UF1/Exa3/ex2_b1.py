import random
# imprimir de que trata el programa
print("JUEGO DE DADOS (2)")
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
        con_num_turno = num_turno +1
        print(f"Turno {con_num_turno}")
        #definir lista donde guardar dados
        dados = []
        #dados del jugador en desbentaja
        dado = random.randint(1,6)
        win = 0
        dados_print = ""
        #calculo de los 4 dados tirados + si alguno coincide con dado
        for num_dado in range(4):
            dados.append(random.randint(1,6))
            if dados[num_dado] == dado:
                win = 1
            dados_print += str(dados[num_dado]) + " "
        #imprimir resultado
        if num_turno % 2 == 0:
            print(f"Tirada de Cubitus: {dados_print}")
            print(f"Tirada de Humerus: {dado}")
            #imprimir quien ha ganado la ronda
            if win == 0:
                humerus += 1
                print("Punto para Humerus")
            else:
                cubitus += 1
                print("Punto para Cubitus")
        else:
            print(f"Tirada de Humerus: {dados_print}")
            print(f"Tirada de Cubitus: {dado}")
            #imprimir quien ha ganado la ronda
            if win == 0:
                cubitus += 1
                print("Punto para Cubitus")
            else:
                humerus += 1
                print("Punto para Humerus")
        print("\n")
    #imprimir resultado partida
    if humerus == cubitus:
        print(f"Han empatado (a {humerus})")
    elif humerus > cubitus:
        print(f"Ha ganado Humerus ({humerus} a {cubitus})")
    else:
        print(f"Ha ganado Cubitus ({cubitus} a {humerus})")
