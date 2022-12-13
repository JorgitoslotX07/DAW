import math

con_list = 0
list_intro = ["primera" , "segunda" , "tercera" , "cuarta" , " quinta"]
list_palabras= []
while con_list < 5:
    print("Introcuce la" , list_intro[con_list] , "palabra")
    palabra_intro = input("--> ")
    list_palabras.append(palabra_intro)
    con_list += 1

con_list = 0
con_menor = math.inf
while con_list < 5:
    con = 0
    con_lista_palabra = 0
    palabra = list_palabras[con_list]
    lista_palabra = list(palabra)
    for x in range(len(lista_palabra)):
        letra = 0
        for i in range(255):
            palabra = lista_palabra[con_lista_palabra]
            if chr(letra) == palabra:
                con += letra
            letra += 1
        con_lista_palabra += 1
    if con < con_menor:
        palabra_menor = con_list
        con_menor = con
    con_list += 1
print(list_palabras[palabra_menor])