N, M, V = map(int, input().split())
board = {i: [] for i in range(1, N+1)}
for _ in range(M):
    a, b = map(int, input().split())
    board[a].append(b)
    board[b].append(a)

for key in board:
    board[key].sort()

dfs = []
bfs = []
def DFS(d, arr):
    global dfs
    for i in board[d]:
        if visited[i] == 0:
            arr.append(i)
            visited[i] = 1
            dfs.append(str(i))
            DFS(i, arr)
            arr.pop()

def BFS():
    global q, bfs
    while q:
        v = q.pop(0)
        bfs.append(str(v))
        for i in board[v]:
            if visited[i] == 0:
                q.append(i)
                visited[i] = 1

s = []
s.append(V)
visited = [0]*(N+1)
visited[V] = 1
dfs.append(str(V))
DFS(V, [])

q = []
q.append(V)
visited = [0]*(N+1)
visited[V] = 1
BFS()

print(' '.join(dfs))
print(' '.join(bfs))