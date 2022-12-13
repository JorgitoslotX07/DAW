print("REPETICIONS\n")

num = int(input("Escriu un número enter: "))
rep = int(input("Quants números va a inscriure? "))
con = 0
for i in range(rep):
    num1 = int(input("Escriu un número enter: "))
    if num1 == num:
        con += 1
if con < (rep / 2):
    print(f"\nHa escrit menys vegades el número {num} que la resta de números.")
elif con > (rep / 2):
    print(f"\nHa escrit més vegades el número {num} que la resta de números.")
else:
    print(f"\nHa escrit tantes vegades el número {num} que la resta de números.")
print("\nPrograma terminar")