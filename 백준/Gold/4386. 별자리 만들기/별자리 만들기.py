import sys
input = sys.stdin.readline

n = int(input())
star = []
for i in range(n):
    x, y = map(float, input().split())
    star.append([i, x, y])

VE = []
for a in range(n):
    for b in range(a + 1, n):
        _, ax, ay = star[a]
        _, bx, by = star[b]

        dis = ((ax - bx) ** 2 + (ay - by) ** 2) ** 0.5

        VE.append((a, b, dis))

VE.sort(key=lambda x: x[2])

def find_set(v):
    while v != star[v][0]:
        v = star[v][0]
    return v

MST = 0
for ve in VE:
    a, b, d = ve
    ap = find_set(a)
    bp = find_set(b)
    if ap != bp:
        star[max(ap, bp)][0] = min(ap, bp)
        MST += d

print(MST)