ancho = int(input("Amplada del rectagle: "))
alt = int(input("Alçada del rectagle: "))
es_ancho = ancho * "*"
es_alt = (ancho - 2) * " "
lin = alt
while lin != 0:     
    if lin == alt or lin == 1:
        print(es_ancho)
    else:
        print(f"*{es_alt}*")
    lin -= 1