import os, time
os.system ("clear")
ok = True
while ok:
    opcion = int(input("##########################     Menu     ##########################\n\t0 - Salir\n\t1 - Mostrar el directorio actual de trabajo\n\t2 - Mostrar cusntos usuarios hay de alta en el sistema\n\t3 - Mostar los cliente/usuarios conectados actualemnte al equipo\n\t4 - Mostrar si un usuario esiste, y es administrador\n\t5 - Hacer ping a IP y NombreEquipo\n\t6 - Crear usuario\nIntroduce el numero de la opcion a realizar --> "))
    os.system ("clear")
    if opcion == 0:
        ok = False
    else:
        if opcion == 1:
            print("Directorio actual: \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
            time.sleep(0.2)
            os.system("pwd")
        elif opcion == 2:
            print("Usuarios en este equipo: \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
            time.sleep(0.2)
            os.system("getent passwd | awk -F: '{ print $1}'")
        elif opcion == 3:
            print("Usuarios conectados en este equipo: \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
            time.sleep(0.2)
            os.system("w")
        elif opcion == 4:
            print("Usuarios en este equipo: \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯")
            nom_usuario = input("Introsuce un nombre de usuario --> ")
            time.sleep(0.2)
            veces = os.system("getent passwd | wc -l")
            for i in range(veces):
                pass
            usuario = os.system(f"getent passwd {nom_usuario}")
            """
            if os.geteuid() != 0:
                print("El usuario no tiene permisos root")
            """
            print(usuario)
            
             
             
        elif opcion == 5:
            pass    
        elif opcion == 6:
            pass    
        else:
            print("La opcion seleciona no existe, porfavor inserte una opcion valida")
        time.sleep(0.5)
        limpiar = input("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\nPulsa ENTER para borrar")   
        os.system ("clear") 
