while True:
    num = int(input("Dona'm un número: "))
    if num > 0:
        break
    else:
        print("¡¡ERROR!! Introduce un numero positivo")
con = 1
con1 = ""
while con <= num:
    if num % con == 0:
        con1 += " " + str(con)
    con += 1
print(f"Els divisors de {num} són: {con1}")
    