import sys
input = sys.stdin.readline

T = int(input())

def is_same(a, b):
    _, ax, ay, ar = a
    _, bx, by, br = b
    if (ax-bx)**2 + (ay-by)**2 <= (ar+br)**2:
        return True
    return False

def union(a, b):
    ap = find(a)
    bp = find(b)
    if ap != bp:
        circle[bp][0] = ap

def find(a):
    if a != circle[a][0]:
        circle[a][0] = find(circle[a][0])
    return circle[a][0]

for _ in range(T):
    N = int(input())
    circle = [0 for _ in range(N)]
    for n in range(N):
        x, y, R = map(int, input().split())
        circle[n] = [n, x, y, R]

    for i in range(N):
        for j in range(i+1, N):
            if circle[i][0] != circle[j][0] and is_same(circle[i], circle[j]):
                union(i, j)

    # print(circle)

    ans = 0
    for i in range(N):
        if circle[i][0] == i:
            ans += 1

    print(ans)