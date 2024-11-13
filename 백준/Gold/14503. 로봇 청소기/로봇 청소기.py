N, M = map(int, input().split())
# 처음에 로봇 청소기가 있는 칸의 좌표 (r, c)와 처음에 로봇 청소기가 바라보는 방향 d
r, c, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

def is_range(r, c):
    if board[r][c] == 1:
        return False
    return True

def is_clean(r, c):
    for dr, dc in zip(drs, dcs):
        nr, nc = r+dr, c+dc
        if is_range(nr, nc) and board[nr][nc] == 0:
            return False
    return True

# d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
drs, dcs = [-1, 0, 1, 0], [0, 1, 0, -1]

ans = 0
# 0인 경우 (i, j)가 청소되지 않은 빈 칸이고, 1인 경우 (i, j)에 벽
while True:
    # 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    if board[r][c] == 0:
        board[r][c] = 2
        ans += 1
    # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
    if is_clean(r, c):
        # 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        nr, nc = r-drs[d], c-dcs[d]
        if is_range(nr, nc):
            r, c = nr, nc
        # 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        else:
            break
    # 현재 칸의 주변 4$칸 중 청소되지 않은 빈 칸이 있는 경우,
    else:
        for _ in range(4):
            # 반시계 방향으로 90도 회전한다.
            d = (d-1)%4
            nr, nc = r + drs[d], c + dcs[d]
            # 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            if is_range(nr, nc) and board[nr][nc] == 0:
                r, c = nr, nc
                break
            # 1번으로 돌아간다.

print(ans)