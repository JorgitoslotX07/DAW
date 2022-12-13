import os
import platform

sistema = platform.system()
num = int(input(" "))

if sistema == "Windows":
    os.system ("clr")
else:
    os.system ("clear")

con = 0
num_mod = 0
while con < 10:
    num_mod += num
    print(num_mod , end="    ")
    con += 1
print("")

con = 0
num_mod = num * 2
while con < 10:
    print(num_mod , end="    ")
    con += 1
    num_mod += (num * 2)
print("")

con = 0
num_mod -= (num * 2)
while con < 10:
    print(num_mod , end="    ")
    con += 1
    num_mod += (num * 2)
print("")

con = 0
num_mod = num * 10
while con < 6:
    print(num_mod , end="    ")
    con += 1
    num_mod += (num * 4)
print("")

num_mod = num * 40
con = num * 9
while con != 0:
    print(num_mod , end="    ")
    con -= 1
    num_mod -= (num * 5)
print("")