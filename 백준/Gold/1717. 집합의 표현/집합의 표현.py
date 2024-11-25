import sys
input = sys.stdin.readline

n, m = map(int, input().split())
sets = [i for i in range(n+1)]

def union(a, b):
    A = find_set(a)
    B = find_set(b)
    sets[max(A, B)] = min(A, B)

def find_set(a):
    while a != sets[a]:
        a = sets[a]
    return sets[a]

for _ in range(m):
    com, a, b = map(int, input().split())
    if com == 0:
        union(a, b)
    elif com == 1:
        if find_set(a) == find_set(b):
            print("yes")
        else:
            print("no")