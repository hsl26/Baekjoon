A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())
F = int(input())

sci = A+B+C+D - min(A, B, C, D)
soc = max(E, F)

print(sci+soc)