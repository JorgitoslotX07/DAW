while True:
    num = int(input("Introduce un numero multiple de 10 -->  "))
    if num % 10 == 0:
        elevat = 0
        while num % 10 == 0 and num > 10:
            num = num / 10
            elevat += 1
        print(f"{int(num)} per 10 elevat a {elevat}")
        break