cant_num = int(input("Quant números vas a introduir? "))
con = 0
con1 = 0
while con < cant_num:
    con += 1
    num = float(input(f"Dona'm el número {con}: "))
    if num < 0:
        con1 += 1
print(f"Has escrit 3 números negatius.")