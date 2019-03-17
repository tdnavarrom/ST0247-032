from ALGraph import *
from AMGraph import *
import math 

#Hecho por Tomas Navarro Y Pablo Correa

class Backtracking:

    def minimumCostMain(self, g, start, end):
        evaluated = [False]*g.size
        cost = self.minimumCost(g, start, end, math.inf , 0, evaluated)
        if cost == math.inf: return "No hay camino posible"
        else: return cost

    def minimumCost(self, g, start_v, end_v, minCost, accumulated, evaluated):
        evaluated[start_v] = True
        if start_v == end_v:
            if minCost > accumulated: minCost = accumulated
            return minCost
        else:
            children = g.getSuccessors(start_v)
            for kid in children:
                costFatherKid = g.getWeight(start_v,kid)
                if (costFatherKid < minCost and start_v != kid and evaluated[kid] is False):
                    minCost = min(self.minimumCost(g,kid,end_v,minCost,accumulated + costFatherKid, evaluated), minCost)
                    evaluated[kid] = False
            return minCost

prueba = Backtracking()

g1 = ALGraph(5)
g1.addArc(2, 1, 1)
g1.addArc(1, 2, 1)
g1.addArc(1, 4, 1)
g1.addArc(2, 1, 5)
g1.addArc(1, 3, 1)
g1.addArc(1, 1, 1)
g1.addArc(2, 3, 1)
g1.addArc(3, 1, 1)
g1.addArc(3, 4, 3)

print(prueba.minimumCostMain(g1, 0, 5))