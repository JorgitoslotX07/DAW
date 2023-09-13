usuari1 = set()
usuari2 = set()

for i in range(6):
    usuari1.add(input(f"usuari1 {i+1} --> "))
    
for i in range(6):
    usuari2.add(input(f"usuari2 {i+1} --> "))

print(usuari1 & usuari2)
print(usuari1 - usuari2)
print(usuari1 | usuari2)

veces = 0
while veces < 6:
    a = usuari1.pop()
    b = usuari2.pop() 
    if a == b:
        print(f"usuari1: {a} usuari2: {b} Felicitats, heu coincidit")
        veces = 6
    else:
        print(f"usuari1: {a} usuari2: {b} No han coincidit")
        veces += 1
