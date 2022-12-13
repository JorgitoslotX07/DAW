num = int(input("Quants volors va a introduir? "))
while num < 0:
    print("¡Impossible!")
    num = int(input("Quants volors va a introduir? "))
con = 0
num2 = 0
while con < num:
    if con == 0: 
        num1 = int(input("Escriu un nombre: "))
        num2 = num1
    else:
        num2 = int(input(f"Enscriu un nombre diferent de {num1}:"))
    if num1 == num2:
        print(f"¡ {num2} no és diferent de {num1}")
        continue
    else:
        num1 = num2
    con += 1
print("Gràcies per la serva col·laboració")
