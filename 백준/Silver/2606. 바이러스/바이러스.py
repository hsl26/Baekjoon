N = int(input())
pair = int(input())

com = {i:[] for i in range(1, N+1)}
for _ in range(pair):
    n1, n2 = map(int, input().split())
    com[n1].append(n2)
    com[n2].append(n1)


def bfs():
    global q
    while q:
        c = q.pop(0)
        for nc in com[c]:
            if visited[nc] == 0:
                q.append(nc)
                visited[nc] = 1

q = []
visited = [0]*(N+1)

q.append(1)
visited[1] = 1
bfs()

print(sum(visited)-1)