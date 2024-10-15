drs, dcs = [0, 0, 1, -1], [1, -1, 0, 0]

def can_go(r, c):
    if 0 > r or r >= N or 0 > c or c >= M:
        return False
    if board[r][c] == 0 or visited[r][c] == 1:
        return False
    return True

def bfs():
    global q
    while q:
        r, c = q.pop(0)
        for dr, dc in zip(drs, dcs):
            nr, nc = r+dr, c+dc
            if can_go(nr, nc):
                q.append((nr, nc))
                visited[nr][nc] = 1

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    board = [[0]*M for _ in range(N)]
    for _ in range(K):
        c, r = map(int, input().split())
        board[r][c] = 1

    ans = 0
    q = []
    visited = [[0]*M for _ in range(N)]
    for r in range(N):
        for c in range(M):
            if board[r][c] == 1 and visited[r][c] == 0:
                q.append((r, c))
                visited[r][c] = 1
                bfs()
                ans += 1
    print(ans)