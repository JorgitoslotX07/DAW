num = 1
letra = 97
for i in range(9):
    print(num , chr(letra))
    letra += 1
    num += 1
 
# Como no se muy bien a que te referias he hecho otra bariante, por si esta esta y no la otra
"""
num = 1
for i in range(9):
    letra = 97
    for x in range(26):
        print(num , chr(letra))
        letra += 1
    num += 1
"""