# Programa para de terminar si un grafo es bipartito o no 
  

#Parte de este codigo es tomado de https://www.geeksforgeeks.org/bipartite-graph/
class Graph(): 
  
    def __init__(self, V): 
        self.V = V 
        self.graph = [[0 for column in range(V)]\
        for row in range(V)] 
  
    # This function returns true if graph G[V][V]  
    # is Bipartite, else false 
    def isBipartite(self, src): 
  
        # Create a color array to store colors  
        # assigned to all veritces. Vertex 
        # number is used as index in this array.  
        # The value '-1' of  colorArr[i] is used to  
        # indicate that no color is assigned to  
        # vertex 'i'. The value 1 is used to indicate  
        # first color is assigned and value 0 
        # indicates second color is assigned. 
        colorArr = [-1] * self.V 
  
        # Assign first color to source 
        colorArr[src] = 1
  
        # Create a queue (FIFO) of vertex numbers and  
        # enqueue source vertex for BFS traversal 
        queue = [] 
        queue.append(src) 
  
        # Run while there are vertices in queue  
        # (Similar to BFS) 
        while queue: 
  
            u = queue.pop() 
  
            # Return false if there is a self-loop 
            if self.graph[u][u] == 1: 
                return False
  
            for v in range(self.V): 
  
                # An edge from u to v exists and destination  
                # v is not colored 
                if self.graph[u][v] == 1 and colorArr[v] == -1: 
  
                    # Assign alternate color to this  
                    # adjacent v of u 
                    colorArr[v] = 1 - colorArr[u] 
                    queue.append(v) 
  
                # An edge from u to v exists and destination  
                # v is colored with same color as u 
                elif self.graph[u][v] == 1 and colorArr[v] == colorArr[u]: 
                    return False
  
        # If we reach here, then all adjacent  
        # vertices can be colored with alternate  
        # color 
        return True
  
# Driver program to test above function 
file=open("Entrada.txt","r") 
for i in range (0, 22):
    print (file.readline(i))
file.close
#Caso 1
    #3-numero de arcos (E)
    #3-numero de nodos (V)
    #0 1
    #1 2
    #2 0
g1 = Graph(3)
           # 0  1  2  
g1.graph = [[0, 1, 1], #0
            [1, 0, 1], #1
            [1, 1, 0]  #2
            ] 
print (g1.graph)  
if (g1.isBipartite(0)): 
  print ("Es Bicoloreable :)")
else: 
  print("No es Bicoloreable :(")
#Caso 2
    #3-numero de nodos (V)
    #2-numero de arcos (E)
    #0 1
    #1 2

g2 = Graph(3)
           # 0  1  2  
g2.graph = [[0, 1, 0], #0
            [1, 0, 1], #1
            [0, 1, 0]  #2
            ]  

print (g2.graph)  
if (g2.isBipartite(0)): 
  print ("Es Bicoloreable :)")
else: 
  print("No es Bicoloreable :(")
#Caso 3
    #9-numero de nodos (V)
    #8-numero de arcos (E)
    #0 1
    #0 2
    #0 3
    #0 4
    #0 5
    #0 6
    #0 7
    #0 8
g3 = Graph(9)
           # 0  1  2  3  4  5  6  7  8 
g3.graph = [[0, 1, 1, 1, 1, 1, 1, 1, 1], #0
            [1, 0, 0, 0, 0, 0, 0, 0, 0], #1
            [1, 0, 0, 0, 0, 0, 0, 0, 0], #2
            [1, 0, 0, 0, 0, 0, 0, 0, 0], #3
            [1, 0, 0, 0, 0, 0, 0, 0, 0], #4
            [1, 0, 0, 0, 0, 0, 0, 0, 0], #5
            [1, 0, 0, 0, 0, 0, 0, 0, 0], #6
            [1, 0, 0, 0, 0, 0, 0, 0, 0], #7
            [1, 0, 0, 0, 0, 0, 0, 0, 0]  #8
            ] 
print (g3.graph)  
if (g3.isBipartite(0)): 
  print ("Es Bicoloreable :)")
else: 
  print("No es Bicoloreable :(")
# This code is contributed by Divyanshu Mehta 