# busqueda https://uniwebsidad.com/libros/python/capitulo-6/metodos-de-validacion
vali = True
while vali:
    nom = input("Inserta un nom -->  ")
    #validar largo nombre
    vali_larg = len(nom)
    #validar caracteres especiales
    vali_espe = nom.isalnum()
    if vali_larg < 6:
        print("El nom d'usuari ha de contenir almenys 6 caràcters")
    elif vali_larg > 12:
        print("El nom d'usuari no pot contenir més de 12 caràcters")
    elif not vali_espe:
        print("El nom d'usuari pot contenir només lletres i números")
    else:
        print(vali)
        vali = False



