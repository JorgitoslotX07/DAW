dic = {}

veces = int(input("Cuantos alumnos vas a introducir? "))

for i in range(veces):
    nombre = input("Ingresar nombre --> ")
    notas = []
    nota = 0
    nota = float(input("Ingresar nota --> "))
    while nota >= 0:
        notas.append(nota)
        nota = float(input("Ingresar nota --> "))
    dic_new = {nombre : notas}
    dic.update(dic_new)

for key in dic:
    print(key  , "-->" ,  end=" ")
    can_notas = len(dic[key])
    con = 0
    for i in range(can_notas):
        con += dic[key][i]
    notas_def = con / can_notas
    print("{:.2f}".format(notas_def))
