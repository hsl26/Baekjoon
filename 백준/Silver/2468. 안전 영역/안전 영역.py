N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

# 지역의 최대 높이
max_height = 0
for lst in board:
    max_height = max(max_height, max(lst))

drs, dcs = [0, 0, 1, -1], [1, -1, 0, 0]

def can_go(r, c):
    if 0 > r or r >= N or 0 > c or c >= N:
        return False
    if visited[r][c] == 1 or board[r][c] <= h:
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

max_safe = 0
for h in range(0, max_height+1):
    q = []
    visited = [[0]*N for _ in range(N)]

    cnt_safe = 0 # 안전 영역 수 초기화
    for r in range(N):
        for c in range(N):
            if board[r][c] > h and visited[r][c] == 0:
                cnt_safe += 1
                q.append((r, c))
                visited[r][c] = 1
                bfs()

    max_safe = max(max_safe, cnt_safe)

print(max_safe)