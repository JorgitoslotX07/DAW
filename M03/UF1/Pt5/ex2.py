import random
import time

jugar = True
while jugar:
    anna = 9
    bernat = 9
    while (anna >= 0 and bernat >= 0) or (anna == 9 and bernat == 9):
        print(f"Anna: {anna}p\tBernat: {bernat}p")
        dado = random.randint(1,6)
        print(f"Dado: {dado}")
        if dado == 1 or dado == 3 or dado == 5:
            anna += dado
            bernat -= dado
        else:
            bernat += dado
            anna -= dado
        time.sleep(0.5)
    if anna <= 0:
        print(f"Gana Bernat ({bernat}p)")
    else:
        print(f"Ganna Anna ({anna}p)")
    decision = " "
    while decision < "1" or decision > "2":
        decision = str(input("Quieres seguir jugando?\n\t1 - Si\n\t2 - No\n-->  "))
        if decision < "1" or decision > "2":
            print("Selecione una de las 2 opcions (1 o 2)")
        elif decision == "2":
            jugar = False
print("\n# Gracias por jugar #")
