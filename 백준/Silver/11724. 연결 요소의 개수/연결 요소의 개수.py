import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = {i: [] for i in range(1, N+1)}
for _ in range(M):
    u, v = map(int, input().split())
    graph[u] += [v]
    graph[v] += [u]


def bfs():
    global q
    while q:
        v = q.pop(0)
        for n in graph[v]:
            if visited[n] == 0:
                q.append(n)
                visited[n] = 1


visited = [0] * (N+1)
ans = 0
for i in range(1, N+1):
    if visited[i] == 0:
        q = []
        q.append(i)
        visited[i] = 1
        bfs()
        ans += 1

print(ans)