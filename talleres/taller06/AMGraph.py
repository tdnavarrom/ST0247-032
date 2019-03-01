
class AMGraph:
    matriz = []
    size = 0
    def __init__(self, size):
        self.size = size
        for i in range(size):
            self.matriz.append([10]*size)

    #Retorna la matriz
    def getEdges(self):
        return self.matriz
    #Retorna el peso del arco
    def getWeight(self, source, destination):
        return self.matriz[source][destination]
    #Metodo para anadir arcos 
    def addArc(self, source, destination, weight):
        self.matriz[source][destination]=weight
    #Metodo que retorna el sucuesor de un vertice
    def getSuccessors(self, vertex):
        lista = []
        for i in range(self.size):
            if(self.matriz[vertex][i] != -1):
                lista.append(i)

        return lista

    def __str__(self):
        for i in self.matriz:
            print(i) 

