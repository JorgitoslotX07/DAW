import math , time

       
def tem_max_min_med(list_tem):
    #max = max(list_tem)
    #min = min(list_tem)
    time.sleep(0.5)
    if len(list_tem) != 0:
        max = maxi(list_tem)
        min = mini(list_tem)
        media = medi(list_tem)        
        print(f"Tempreaturas:\n{list_tem}")
        print(f"Temperatura maxima --> {max}")
        print(f"Temperatura minima --> {min}")
        print(f"Temperatura media --> {round(media, 2)}")      
    else:
        print(f"Tempreaturas:\n{list_tem}")
        print(f"Temperatura maxima --> 0")
        print(f"Temperatura minima --> 0")
        print(f"Temperatura media --> 0")  
    time.sleep(1)
 
def maxi(list_tem):
    """
        Calcula el maximo
    """
    max = -math.inf
    for i in range(len(list_tem)):
        if list_tem[i] > max:
            max = list_tem[i]
    return max
def mini(list_tem):
    """
        Calcula el minimo
    """
    min = math.inf
    for i in range(len(list_tem)):
        if list_tem[i] < min:
            min = list_tem[i]
    return min
def medi(list_tem):
    """
        Calcula la media
    """
    con = 0
    for i in range(len(list_tem)):
        con += list_tem[i]
    media =  con / len(list_tem)  
    return media
    
def pedir_temp(tipo,veces,ubi="-1"):
    """
        Pide temperatuas el numeor de veces que se le pida, y unicamente realizara una accion 'especial' la prima vez
    """
    print("Rango de temperaturas permitidas:\n\t- Min: -50\n\t- Max: 50")
    bucle = 0
    while bucle < veces:
        try:
            tem = float(input(f"Introduca la temperatura maxima del dia ({bucle + 1}) --> "))
            if tem >= -50 and tem <= 50:
                if bucle == 0:
                    tipo_una(tipo,tem,ubi)
                else:
                    list_tem.append(tem)
                bucle += 1
            else:
                error_valores()
        except:
            error_valores()
    return
def tipo_una(tipo,tem,ubi):
    """
        Funcion hecha para la hora de los casos especiales que se pueden dar
    """
    if tipo == 1:
        list_tem.insert(0, tem)
    elif tipo == 2:
        list_tem[ubi] = tem
    else:
        list_tem.append(tem)
    return

def error_valores():
    """
        Mensaje de ERROR estandar
    """
    return print("ERROR, debe introducir uno de los valores señalados anteriormente")

def sustituir_temp(list_tem):
    """
        Sustitulle un valoar dependiendo de la ubicacion que se le indique de una lista
    """
    bucle = True
    while bucle:
        try:
            ubi = int(input(f"Indique una posicion de la a anterior lista mostrada: \n\t-Min: 0\n\t-Max: {len(list_tem) - 1}\n--> "))
            if ubi < len(list_tem) and ubi >= 0:
                bucle = False
            else:
                error_valores()
        except:
            error_valores()
    pedir_temp(2,1,ubi)
    return

def temp_calidas(calides):
    """
        Separa las temperatias calidas para agregarlas a su lista
    """
    for i in range(len(calides) - 1 , - 1 , - 1):
        if calides[i] < 30:
            del calides[i]  
    return calides

def temp_templadas(list_tem):
    """
        Separa las temperatias templadas para agregarlas a su lista
    """
    for i in range(len(list_tem)):
        if list_tem[i] >= 15 and list_tem[i] < 30:
            temperades.append(list_tem[i])
    return temperades
            
def temp_fredes(list_tem):
    """
        Separa las temperatias frias para agregarlas a su lista
    """
    for i in range(len(list_tem)):
        if list_tem[i] < 15:
            fredes.append(list_tem[i])
    return fredes
            
def print_tipos_temp(calides , temperades , fredes):
    """
        Muestra los 3 tipos de temperaturas junto con sus respecticas listas
    """ 
    print('Calides: ' , calides)
    print('Temperades: ' , temperades)
    print('Fredes: ' , fredes)
    return

def crear_dic(calides,temperades,fredes):
    """
        Inserta los 3 tipos de temperatua dentro de un disccionario
    """ 
    dic.setdefault('calides', calides)
    dic.setdefault('temperades', temperades)
    dic.setdefault('fredes', fredes)
    return

def prdentaje_tipo_dias(dic):
    """
        Mustra por pantalla los 3 tipos de temperatura junto con sus porcentajes respecto al numero total de dias
    """ 
    ## Guardar en 2 listas la 'key' del diccionario y su respectiva lista
    #dies = 0
    #list_dia = []
    #list_key = []
    #for key in dic:
    #    dies += len(dic[key])
    #    list_dia.append(len(dic[key]))
    #    list_key.append(key)
    #
    ## Salto de tiempo    
    #time.sleep(0.6)
    #
    ## Printar la lista los 3 tipos de temperatuas en porcentaje (%) y con solo 2 decimales
    #print('Dies totals: ', dies)
    #for i in range(len(list_dia)):
    #    print(list_key[i] , '--> ', "{:.2f}".format(list_dia[i] * 100 / dies) , '%')
    dies = 0
    for key in dic:
        dies += len(dic[key])
    print('Dies totals: ', dies)
    for key in dic:
        print(key , '--> ' , "{:.2f}".format(len(dic[key]) * 100 / dies) , '%')
        
    # Salto de tiempo
    time.sleep(0.3)
    return
    
def visualizar_tipo_temp(): 
    """
        Pide una de los 3 tipos de temperaturas, para despuesde devolver este
    """   
    # Pedir que introduza un tipo de temparatura
    bucle = True
    while bucle:
            ctf = input("Indique cual de los anteriores porcentajes desa visualizar  (Calides|Temperades|Fredes)--> ")
            #Comprobar si las letras coinciden, aparte de convertir todas las letras a minuscula
            ctf = ctf.lower()
            if ctf == 'calides' or ctf == 'temperades' or ctf == 'fredes':
                bucle = False
            else:
                error_valores()
    time.sleep(1)
    print("Dias" , ctf , ': ' , len(dic[ctf]))
    return dic[ctf]    



def main(list_tem , calides , temperade , fredes , dic):
    pedir_temp(0,10)
    tem_max_min_med(list_tem)
    
    pedir_temp(1,2)
    tem_max_min_med(list_tem)
    
    sustituir_temp(list_tem)
    tem_max_min_med(list_tem)
    
    print("Eliminando temperaturas inferiores de 30ºC...")
    time.sleep(1.3)

    calides = list_tem.copy()
    temp_calidas(calides) 
    tem_max_min_med(calides)
    temp_templadas(list_tem)     
    temp_fredes(list_tem)
    print_tipos_temp(calides , temperades , fredes)
    crear_dic(calides,temperades,fredes)
    
    prdentaje_tipo_dias(dic)
    tem_max_min_med(visualizar_tipo_temp())


##### COMIENZO CODIGO ####
"""
if __name__ == '__main__':
    list_tem = []

    pedir_temp(0,10)
    tem_max_min_med(list_tem)

    pedir_temp(1,2)
    tem_max_min_med(list_tem)

    sustituir_temp(list_tem)
    tem_max_min_med(list_tem)

    print("Eliminando temperaturas inferiores de 30ºC...")
    time.sleep(1)
    # Eliminar tempetaruas por debajo de 30ºC y guardarlas en otra lista
    calides = list_tem.copy()
    temp_calidas(calides) 
    tem_max_min_med(calides)

    temperades = []
    temp_templadas(list_tem)
    fredes = []
    temp_fredes(list_tem)

    print_tipos_temp()

    # Crear dicionarios y listas
    dic = {}
    crear_dic(calides,temperades,fredes)

    prdentaje_tipo_dias(dic)

    tem_max_min_med(visualizar_tipo_temp())   
""" 
# Crear varaibles globales
list_tem = []
calides = []
temperades = []
fredes = []
dic = {}

main(list_tem , calides , temperades , fredes , dic)
