n = int(input())

def F(F0, F1):
    return F1, F0+F1

f0 = 0
f1 = 1
for _ in range(n):
    f0, f1 = F(f0, f1)
print(f0)