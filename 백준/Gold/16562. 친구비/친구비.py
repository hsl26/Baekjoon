import sys
input = sys.stdin.readline

N, M, k = map(int, input().split())
A = list(map(int, input().split()))

f = [i for i in range(N)]

def find(a):
    if a != f[a]:
        f[a] = find(f[a])
    return f[a]

def union(a, b):
    a_p = find(a)
    b_p = find(b)
    if a_p != b_p:
        if A[a_p] < A[b_p]:
            f[b_p] = a_p
        else:
            f[a_p] = b_p


for _ in range(M):
    v, w = map(int, input().split())
    union(v-1, w-1)

p = set()
for i in f:
    p.add(find(i))

m = 0
for i in p:
    m += A[i]

if m > k:
    print("Oh no")
else:
    print(m)