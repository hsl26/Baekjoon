R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]

drs, dcs = [0, 0, 1, -1], [1, -1, 0, 0]

def is_sink(r, c):
    cnt = 0
    for dr, dc in zip(drs, dcs):
        nr, nc = r+dr, c+dc
        if 0 > nr or nr >= R or 0 > nc or nc >= C or board[nr][nc] == '.':
            cnt += 1
        if cnt >= 3:
            return True
    return False

new_board = []
for lst in board:
    new_board.append(lst[:])

for r in range(R):
    for c in range(C):
        if board[r][c] == 'X':
            if is_sink(r, c):
                new_board[r][c] = '.'

# new_board 테두리 삭제
cor_r = []
cor_c = []
for r in range(R):
    for c in range(C):
        if new_board[r][c] == 'X':
            cor_r.append(r)
            cor_c.append(c)


for r in range(min(cor_r), max(cor_r)+1):
    for c in range(min(cor_c), max(cor_c)+1):
        print(new_board[r][c], end='')
    print()
