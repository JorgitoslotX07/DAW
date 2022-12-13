# busqueda https://uniwebsidad.com/libros/python/capitulo-6/metodos-de-validacion
# https://es.acervolima.com/programa-de-python-para-contar-el-numero-de-espacios-en-una-cadena/
segura = False
vali = True
while vali:
    contra = input("Introduce una contraseña -->  ")
    letra = " "
    #validar largo contra
    vali_larg = len(contra)
    #validar caracteres alfabeticos
    vali_alf = contra.isalpha()
    #validar caracteres numericos
    vali_num = contra.isdigit()
    #validar mayuscula
    vali_mayus = contra.isupper()
    #validar minuscula
    vali_minus = contra.islower()
    #validar espacion en blanco + caracteres especiales
    vali_espe = True
    vali_blanc = False
    for blanc in (contra):
        if blanc == " ":
            vali_blanc = True
        if not blanc.isalnum():
            vali_espe = False
    if vali_larg < 8:
        pass
    elif vali_alf or vali_num:
        pass
    elif vali_espe:
        pass
    elif vali_mayus or vali_minus:
        pass
    elif vali_blanc:
        pass
    else:
        segura = True
    if segura:
        print(segura)
        vali = False
    else:
        print("La contrasenya no és segura")