N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

def can_go(r, c):
    if r < 0 or r >= N or c < 0 or c >= M:
        return False
    if tmp_board[r][c] != 0 or visited[r][c] == 1:
        return False
    return True

drs, dcs = [0, 0, 1, -1], [1, -1, 0, 0]
def bfs():
    global q, tmp_board
    while q:
        r, c = q.pop(0)
        for dr, dc in zip(drs, dcs):
            nr, nc = r+dr, c+dc
            if can_go(nr, nc):
                visited[nr][nc] = 1
                tmp_board[nr][nc] = 2
                q.append((nr, nc))

coordinate = []
for r in range(N):
    for c in range(M):
        if board[r][c] == 0:
            coordinate.append((r, c))

ans = 0
for x in range(len(coordinate)):
    for y in range(x+1, len(coordinate)):
        for z in range(y+1, len(coordinate)):
            tmp_board =  []
            for lst in board:
                tmp_board.append(lst[:])

            visited = [[0]*M for _ in range(N)]

            xr, xc = coordinate[x]
            yr, yc = coordinate[y]
            zr, zc = coordinate[z]
            tmp_board[xr][xc], tmp_board[yr][yc], tmp_board[zr][zc] = 1, 1, 1

            q = []
            for r in range(N):
                for c in range(M):
                    if tmp_board[r][c] == 2 and visited[r][c] == 0:
                        visited[r][c] = 1
                        q.append((r, c))
                        bfs()

            cnt = 0
            for lst in tmp_board:
                cnt += lst.count(0)

            ans = max(ans, cnt)

print(ans)