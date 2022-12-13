#variable para salir del bucle
salir = 0
while salir == 0:
    #menu:
    print("1 - veleros\n2 - motos de agua\n3 - yate\n4 - transatlánatico\n5 - salir")
    #definir unidades por seleccion 
    vel = 200
    mot_agua = 90
    yate = 90
    trans_km = 110
    trans_tm = 40
    #seleccionar opcion
    select = int(input("Seleccione la opción deseada: "))
    #opcion 1, calcular importe velero
    if select == 1:
        print(f"Importe = {vel}")
    #opcion 2, calcular importe moto de agua
    elif  select == 2:
        km = int(input("Kilómetros? "))
        mot_agua = mot_agua * km
        print(f"Importe = {mot_agua}")
    #opcion 3, calcular importe yate
    elif select == 3:
        km = int(input("Kilómetros? "))
        yate = yate * km
        print(f"Importe = {yate}")
    #opcion 4, calcular importe transatlantico
    elif select == 4: 
        km = int(input("Kilometos? "))
        tm = int(input("Toneladas? "))
        trans = (trans_km * km) + (trans_tm * tm)
        print(trans_km,trans_tm)
        print(f"Importe = {trans}")
    #opcion 5, permite salir del programa
    elif select == 5:
        salir = 1
    #el resto
    else:
        print("¡¡ERROR!! Introduce un valor valido")