while True:
    # Introduccion Fecha Nacimiento
    data = int(input("Introduce tu fecha de Nacimiento (ejemplo: 28/06/2004 --> 28062004): "))
    # Calculos para identificar año/mes/dia 
    data_dia = data // 1000000
    data_mes = (data // 10000) - ((data_dia)*100)
    data_año = data - ((data // 10000)*10000)
    # Validaz de datos introducidos
    # Comprobacion del mes introducido
    if data_mes < 1 or data_mes > 12:
        continue
    # Comprobacion del dia introducido
    elif data_mes == 1 or data_mes == 3 or data_mes == 5 or data_mes == 7 or data_mes == 8 or data_mes == 10 or data_mes == 12:
        if data_dia < 1 or data_dia > 31:
            continue
        else:
            break
    # Comprobacion del dia introducido
    elif data_mes == 4 or data_mes == 6 or data_mes == 9 or data_mes == 11:
        if data_dia < 1 or data_dia > 30:
            continue
        else:
            break
    # Comprobacion del dia introducido (en febrero)
    elif data_año % 4 == 0:
        if data_año % 100 == 0:
            if data_año % 400 == 0:
                if data_dia < 1 or data_dia > 29:
                    continue
                else:
                    break
            else:
                if data_dia < 1 or data_dia > 28:
                    continue
                else:
                    break
        else:
            if data_dia < 1 or data_dia > 29:
                continue
            else:
                break
    else:
        if data_dia < 1 or data_dia > 28:
            continue
        else:
            break
#Calcular numero de la suerte
num = data
while num > 9 :
    con = 0
    calc = 0
    if num == data:
        num = 0
        while con != 8:
            calc = data % 10
            num += calc
            data  = data // 10
            con += 1
    else:
        data = num
        num = 0
        while con != 2:
            calc = data % 10
            num += calc
            data  = data // 10
            con += 1
#Imprimir numero de la suerte
print(num)
