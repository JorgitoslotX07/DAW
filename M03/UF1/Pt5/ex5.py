cadena = "La casa blau"
print(cadena)
lista = list(cadena)
valor = lista[2:7]
valor2 = lista[7:12]
lista2 = "".join(map(str, valor))
lista3 = "".join(map(str, valor2))
lista[2:12] = [lista3, lista2]
lista1 = "".join(map(str, lista))
print(lista1)