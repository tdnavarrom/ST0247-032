#This algorithm solves the shortest path for a given graph 

global arr 
arr=[]  #A global list that store every vertex for the shrotest path 


#this method solve in a recursively way every sequences from ai to bi of the graph
def moves(matrix, ai):
    mini = 1000000000 #We define a minimum variable that assure that every other value we be lower than this one
    bi=0
    for j in range(len(matrix[ai])):
        if matrix[ai][j]!=0 and mini>matrix[ai][j]:
            mini=matrix[ai][j]
            bi=j
    if bi==4:
        return 0
    else:
        arr.append(bi+1)
        moves(matrix, bi) #with this we jump to the other vertex and continue the path


#Where ai[0] is the vertex where we are and bi[1] where we want to go
#wi[2] the weight of the edge that join them  
def graph():

    #We create the graph as a matrix, so make sure to change this matrix if want want to test with different cases the algorithm
            #1  2  3  4  5     
    matrix=[[0, 2, 0, 1, 0],#1
            [0, 0, 4, 0, 5],#2
            [0, 0, 0, 0, 1],#3
            [0, 0, 3, 0, 0],#4
            [0, 0, 0, 0, 0]]#5 

    print(len(matrix))  
    cont=0
    for i in range(len(matrix)): 
        for j in range (len(matrix[i])):
                if matrix[i][j]!=0:
                    cont=cont+1               
    print (cont)
    moves(matrix, 0) 
    s="1, {}, {}".format(arr,len(matrix)) 
    s=s.replace("[","")
    s=s.replace("]","")
    print("["+s+"]")

# Here we execute the program above 
graph() 

#@Authors Pablo Correa y Tomas Navarro