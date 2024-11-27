import sys
input = sys.stdin.readline

V, E = map(int, input().split())

arr = []
for _ in range(E):
    A, B, C = map(int, input().split())
    arr.append([A-1, B-1, C])

arr.sort(key=lambda x: x[2])

DS = [i for i in range(V)]

def find_set(a):
    while a != DS[a]:
        a = DS[a]
    return DS[a]

MST = 0
for i in range(E):
    A, B, C = arr[i]
    ap = find_set(A)
    bp = find_set(B)
    
    if ap != bp:
        DS[max(ap, bp)] = min(ap, bp)
        MST += C

print(MST)