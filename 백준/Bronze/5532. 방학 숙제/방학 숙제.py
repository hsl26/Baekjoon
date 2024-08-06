L = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())

kor = A//C if A%C==0 else A//C+1
mat = B//D if B%D==0 else B//D+1

use = max(kor, mat)

print(L-use)