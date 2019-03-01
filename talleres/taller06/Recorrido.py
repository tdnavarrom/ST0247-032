from AMGraph import *

def Recorrido(g, begin):
    for begin in range(g.size):
        hijos = g.getSuccessors(begin)
        j=1
        for j in range(len(hijos)):
            min = g.getWeight(begin, hijos[j])
            if min > hijos[j]:
                min = hijos[j]
            
    print(min)

Recorrido(AMGraph(5), 0) 


