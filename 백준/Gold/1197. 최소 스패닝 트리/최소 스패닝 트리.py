import sys
input = sys.stdin.readline

V, E = map(int, input().split())

arr = []
for _ in range(E):
    A, B, C = map(int, input().split())
    arr.append([C, A-1, B-1])

arr.sort()

DS = [i for i in range(V)]

def find_set(a):
    while a != DS[a]:
        a = DS[a]
    return a

MST = 0
for i in arr:
    C, A, B = i
    ap = find_set(A)
    bp = find_set(B)

    if ap != bp:
        DS[max(ap, bp)] = min(ap, bp)
        MST += C

print(MST)