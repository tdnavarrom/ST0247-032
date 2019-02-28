
def cambioGreedy (n , denominaciones):
    respuesta=[]
    cantidad = 0
    for i in range (len(denominaciones)):
        cantidad = n/denominaciones[i]
        respuesta.append(cantidad)
        n = n % denominaciones[i]
    print(respuesta)


cambioGreedy(2300, [1000,500,200,100,50])