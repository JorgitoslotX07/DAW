import os
import platform
sistema = platform.system()
nave = []
num = 0
while num != 6:
    print("1 - Introduir vehicle\n2 - Consultar dades d'un vehicle\n3 - Consultar dades d'un vehicle per tipus de vehicle\n4 - Llistar tots el vehicles\n5 - Donar de baixa un vehicle\n6 - Sortir")
    num = int(input("Inserte el numero de la opcion a realizar --> ")) 
    # Opcion 1
    if num == 1:
        if len(nave) <= 20:
            nom = input("Inserte el nombre del propietrario  --> ")
            tipo = input("Introçduce el tipo de vehiculo:\n\tTurisme\n\tMotos\n\tAutocaravanes\n\tFurgonetes\n\tCamions\n --> ")
            while tipo.lower() != "turisme" and tipo.lower() != "motos" and tipo.lower() and "autocaravanes" and tipo.lower() != "furgonetes" and tipo.lower() != "camions":
                print("Inserte un tipo de vehiculo correcto")
                tipo = input("Introçduce el tipo de vehiculo:\n\tTurisme\n\tMotos\n\tAutocaravanes\n\tFurgonetes\n\tCamions\n --> ") 
            matri = input("Inserte la Matricula del vehiculo --> ")
            fal = True
            while fal:
                matri_comproba = list(matri)
                con = 0
                fal1 = True
                fal2 = True
                for i in range(6):
                    if i < 3:
                        if matri_comproba[i].isdigit():
                            fal1 = False
                    else:
                        if not matri_comproba[i].isdigit():
                            fal2 = False
                    con += 1
                
                if not fal1 and not fal2:
                    fal = False
                else:
                    matri = input("Introduce una Matricula Valida --> ")
            nave.append([nom.lower(),tipo.lower(),matri.lower()])
        else:
            print("La capacidad de la nave ha sido excedida")
    elif num == 2:
        tipo = input("Introçduce el tipo de vehiculo:\n\tTurisme\n\tMotos\n\tAutocaravanes\n\tFurgonetes\n\tCamions\n --> ")
        while tipo.lower() != "turisme" and tipo.lower() != "motos" and tipo.lower() and "autocaravanes" and tipo.lower() != "furgonetes" and tipo.lower() != "camions":
            print("Inserte un tipo de vehiculo correcto")
            tipo = input("Introçduce el tipo de vehiculo:\n\tTurisme\n\tMotos\n\tAutocaravanes\n\tFurgonetes\n\tCamions\n --> ")
        veces = 0
        for x in range(len(nave)):
            if nave[x][1] == tipo.lower():
                print(f"Nom - {nave[x][0]}\nTipo - {nave[x][1]}\nMatricula - {nave[x][2]}")
                veces += 1
        if veces == 0:
            print("No hi ha cap classe de vehicle ara mateix amb cita a les nostres instal·lacions")
    elif num == 3:
        nom = input("Inserte el nombre del propietrario  --> ")        
        veces = 0
        for x in range(len(nave)):
            if nave[x][0] == nom.lower():
                print(f"Nom - {nave[x][0]}\nTipo - {nave[x][1]}\nMatricula - {nave[x][2]}")
                veces += 1
        if veces == 0:
            print("No hi ha cap vehicle amb aquest nom de propietari")
    elif num == 4:
        for x in range(len(nave)):
            print(f"Nom - {nave[x][0]}\nTipo - {nave[x][1]}\nMatricula - {nave[x][2]}\n")
    elif num == 5:
        matri = input("Inserte la Matricula del vehiculo que quiere eliminar --> ")
        segur = input("Esta seguro de seguir adelante?, los datos se borraran de forma permanente (Sí = s , No = n) --> ")
        if segur == "s":
            for x in range(len(nave)):
                if nave[x][2] == matri.lower():
                    nave[x] = []
                    nave.remove([])
    elif num == 6:
        pass
    else:
        print("Seleccione una opcion existente")
    
    #Borrar
    supr = input("")
    if sistema == "Windows":
        os.system ("clr")
    else:
        os.system ("clear")