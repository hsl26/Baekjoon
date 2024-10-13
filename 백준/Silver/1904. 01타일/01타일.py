N = int(input())

F = 1
f1 = 1
f2 = 1

for i in range(2, N+1):
    F = (f1 % 15746 + f2 % 15746) % 15746
    f1 = f2
    f2 = F

print(F % 15746)