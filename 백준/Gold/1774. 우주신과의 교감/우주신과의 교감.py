import sys
input = sys.stdin.readline

N, M = map(int, input().split())

# N개의 줄에는 황선자를 포함하여 우주신들의 좌표가 X, Y 주어짐
arr = []
for i in range(N):
    x, y = map(int, input().split())
    arr.append([i, x, y])

def find_set(v):
    while v != arr[v][0]:
        v = arr[v][0]
    return v


def union(a, b):
    ap = find_set(a)
    bp = find_set(b)
    if ap != bp:
        arr[max(ap, bp)][0] = min(ap, bp)


def cal_dis(a, b):
    _, ax, ay = arr[a]
    _, bx, by = arr[b]
    dis = ((ax-bx)**2 + (ay-by)**2)**0.5
    return dis

MST = 0
# M개의 줄에는 이미 연결된 통로가 주어진다.
for _ in range(M):
    a, b = map(int, input().split())
    union(a-1, b-1)

VE = []
for i in range(N):
    for j in range(i+1, N):
        VE.append((i, j, cal_dis(i, j)))

VE.sort(key=lambda x: x[2])

for ve in VE:
    a, b, c = ve
    ap = find_set(a)
    bp = find_set(b)

    if ap != bp:
        arr[max(ap, bp)][0] = min(ap, bp)
        MST += c

print(format(MST, ".2f"))