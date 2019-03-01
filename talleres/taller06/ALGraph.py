
class ALGraph:
    size = 0
    def __init__(self, size):
        self.size = size
        self.graph = {}
        for i in range(self.size):
            self.graph[i] = []


    def addArc(self, vertex, edge, weight):
        # Añade un arco SI existe el vertice
        try:
            self.graph[vertex].append((edge, weight))
        except KeyError:
            # Aqui el vertice no esta en el grafo
            print("vertice no figura en grafo")
            pass
    #Determinamos los sucesores de cada vertice
    def getSuccessors(self, vertice):
        list = []
        for i in self.graph[vertice]:
            list.append(i[0])
        return list
    #Retorna el peso del vertice 
    def getWeight(self, source, destination):
        for i in self.graph[source]:
            if(i[0] == destination):
                return i[1]

    def __str__(self):
        # Print the vertex
        s = "Vertex -> Edges\n"
        for k, v in self.graph.items():
            s += "%-6s -> %s\n" % (k, v)
        return s