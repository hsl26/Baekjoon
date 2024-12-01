N, M = map(int, input().split())
E = []
for _ in range(M):
    A, B, C = map(int, input().split())
    E.append((A-1, B-1, C))

# B-F Algo
minus_cycle = False

prev = [-1] * N
d = [float('inf')] * N
d[0] = 0

for _ in range(N-1):
    for (u, v, c) in E:
        if d[u] != float('inf') and d[u] + c < d[v]:
            d[v] = d[u] + c
            prev[v] = u

for (u, v, c) in E:
    if d[u] != float('inf') and d[u] + c < d[v]:
        minus_cycle = True
        break

# 출력
if minus_cycle:
    print(-1)
else:
    for i in range(1, N):
        if d[i] == float('inf'):
            print(-1)
        else:
            print(d[i])