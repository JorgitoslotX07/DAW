"""Per indicar el temps transcorregut des d'una 
data passada, els maies utilitzaven l'anomenat 
compte llarg o sèrie inicial, en què es compta en
kins , uinals , tuns , katúns i baktúns . Un kin 
és un dia, un uinal són 20 kins , un tun són 18 
uinals , un katún són 20 tuns i un baktún són 20 
katunes ."""

print("CUENTA LARGA MAYA")
dias = int(input("Escriba una cantidad de días: "))
# Comprobación numeros
if dias >= 0:
    # Introducion inicial bariables
    dias_tot = dias
    baktun = 0
    katun = 0
    tun = 0
    uinal = 0
    kin = 0

    # Elecion baktun
    while dias_tot > 144000:
        baktun = baktun + 1
        dias_tot -= 144000

    # Elecion katun
    while dias_tot > 7200:
        katun = katun + 1
        dias_tot -= 7200

    # Elecion tun
    while dias_tot > 360:
        tun = tun + 1
        dias_tot -= 360

    # Elecion unial
    while dias_tot > 20:
        uinal = uinal + 1
        dias_tot -= 20

    # Elecion kin
    while dias_tot > 0:
        kin = kin + 1
        dias_tot -= 1

    # Imprimir resultado
    print(f"{dias} días son {baktun} baktún, {katun} katún, {tun} tun, {uinal} uinal y {kin} kin.")

else:
    print("Por favor, no escriba números negativos.")