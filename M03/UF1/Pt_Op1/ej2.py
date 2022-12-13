while True:
    gra = int(input("Escriu la grandària del segment: "))
    seg = int(input("Escriu el número de segments: "))
    if gra > 0 and seg > 0:
        break
    elif gra < 0:
        print("¡No ha escrit un numero entre positiu!")
    elif seg < 0:
        print("¡No ha escrit un numero entre positiu!")
    else:
        print("¡No ha escrit els numeros entrs positius!")
gra_es = gra * "*"
gra_ep = gra * " "
con = 0
while con != seg:
    print(gra_es , gra_ep , end=(""))
    con += 1
