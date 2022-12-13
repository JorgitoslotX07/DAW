"""
Un programa ha de llegir un any pel teclat i ens ha de dir si és any de traspàs o no.
"""

año = int(input("Introduce un año -->  "))

if año % 4 == 0:
    if año % 100 == 0:
        if año % 400 == 0:
            print("El año introducido es BISIESNTO")
        else:
            print("El año introducido NO es BISIESNTO")
    else:
        print("El año introducido es BISIESNTO")
else:
    print("El año introducido NO es BISIESNTO")  