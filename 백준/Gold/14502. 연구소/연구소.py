N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

def can_go(r, c):
    if r < 0 or r >= N or c < 0 or c >= M:
        return False
    if tmp[r][c] != 0 or visited[r][c] == 1:
        return False
    return True

drs, dcs = [0, 0, 1, -1], [1, -1, 0, 0]
def bfs():
    global q, tmp
    while q:
        r, c = q.pop(0)
        for dr, dc in zip(drs, dcs):
            nr, nc = r+dr, c+dc
            if can_go(nr, nc):
                visited[nr][nc] = 1
                tmp[nr][nc] = 2
                q.append((nr, nc))

tmp_board = []
for lst in board:
    tmp_board.append(lst[:])

coordinate = []
for r in range(N):
    for c in range(M):
        if board[r][c] == 0:
            coordinate.append((r, c))

ans = 0
for x in range(len(coordinate)):
    for y in range(x+1, len(coordinate)):
        for z in range(y+1, len(coordinate)):
            tmp =  []
            for lst in tmp_board:
                tmp.append(lst[:])

            visited = [[0]*M for _ in range(N)]

            xr, xc = coordinate[x]
            yr, yc = coordinate[y]
            zr, zc = coordinate[z]
            tmp[xr][xc], tmp[yr][yc], tmp[zr][zc] = 1, 1, 1

            q = []
            for r in range(N):
                for c in range(M):
                    if tmp[r][c] == 2 and visited[r][c] == 0:
                        visited[r][c] = 1
                        q.append((r, c))
                        bfs()

            cnt = 0
            for lst in tmp:
                cnt += lst.count(0)

            ans = max(ans, cnt)

print(ans)