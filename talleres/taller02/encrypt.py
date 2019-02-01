#algoritmo para pemutar cualquier tipo de palabra con el numero de letras de esa palabra que desea permutar
import itertools 
letters=input("Escriba la palabra que desea permutar: ")
permutations = []
x=input("Escriba el numero de letras de la palabra que desea permutar: ")
for i in range (len(letters)): 
    permutations.extend ([''.join(l) for l in itertools.permutations(letters, i+1)])
for i in range (len(permutations)): 
    if(len(permutations[i])==x): 
        print("["+permutations[i]+"]")
        i+1
    else: 
       i+1 


