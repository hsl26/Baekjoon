N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

graph = {i:[] for i in range(N)}

for r in range(N):
    for c in range(N):
        if board[r][c] == 1:
            graph[r].append(c)


for v in range(N):
    for r in range(N):
        for c in range(N):
            if board[r][v] == 1 and board[v][c] == 1:
                board[r][c] = 1

for row in board:
    print(*row)