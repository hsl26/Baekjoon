n, m = map(int, input().split())
E = []

for _ in range(m):
    u, v, w = map(int, input().split())
    E.append([u-1, v-1, w])

prev = [-1] * n
d = [-1 * float('inf')] * n
d[0] = 0
flg = True

for _ in range(n-1):
    for idx, [u, v, w] in enumerate(E):
        if d[u] != -1 * float('inf') and d[u] + w > d[v]:
            d[v] = d[u] + w
            prev[v] = u

for (u, v, w) in E:
    if d[u] != -1 * float('inf') and d[u] + w > d[v]:
        d[v] = float('inf')

if d[n-1] != float('inf'):
    cur = n-1
    res = []
    while cur != -1:
        res.append(str(cur + 1))
        cur = prev[cur]
    res.reverse()
    print(' '.join(res))
else:
    print(-1)