print("VELOCIDAD")

distancia = str(input("Unidad de distancia (m o km): "))
if distancia == "m" or distancia == "km":
    distancia_recorrida = float(input("Distacia recorrida: "))
    tiempo = str(input("Unidad de tiempo (s o h): "))
    if tiempo == "s" or tiempo == "h":
        tiempo_recorrido = float(input("Tiempo empleado: "))
        if distancia == "m" and tiempo == "s":
            print(f"Si ha recorrido {distancia_recorrida} {distancia} en {tiempo_recorrido} {tiempo} su velocidad ha sido {distancia_recorrida / tiempo_recorrido} m/s ({(distancia_recorrida * 1000) / (tiempo_recorrido * 3600)} km/h).")
        elif distancia == "m" and tiempo == "h":
            print(f"Si ha recorrido {distancia_recorrida} {distancia} en {tiempo_recorrido} {tiempo} su velocidad ha sido {distancia_recorrida / (tiempo_recorrido / 3600)} m/s ({(distancia_recorrida * 1000) / tiempo_recorrido} km/h).")
        elif distancia == "km" and tiempo == "s":
            print(f"Si ha recorrido {distancia_recorrida} {distancia} en {tiempo_recorrido} {tiempo} su velocidad ha sido {(distancia_recorrida / 1000) / tiempo_recorrido} m/s ({distancia_recorrida / (tiempo_recorrido * 3600)} km/h).")
        elif distancia == "km" and tiempo == "h":
            print(f"Si ha recorrido {distancia_recorrida} {distancia} en {tiempo_recorrido} {tiempo} su velocidad ha sido {(distancia_recorrida / 1000) / (tiempo_recorrido / 3600)} m/s ({distancia_recorrida / tiempo_recorrido} km/h).")
    else:
        print("La unidad de timepo que ha indicado no es s o h.")
else:
    print("La unidad de distancia que ha indicado no es m o km.")
