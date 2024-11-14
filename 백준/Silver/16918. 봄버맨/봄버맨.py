R, C, N = map(int, input().split())
board = [list(input()) for _ in range(R)]
drs, dcs = [0, 0, 1, -1], [1, -1, 0, 0]

third_board = [['O']*C for _ in range(R)]
for r in range(R):
    for c in range(C):
        if board[r][c] == 'O':
            third_board[r][c] = '.'
            for dr, dc in zip(drs, dcs):
                nr, nc = r+dr, c+dc
                if 0 > nr or nr >= R or 0 > nc or nc >= C:
                    continue
                else:
                    third_board[nr][nc] = '.'

first_board = [['O']*C for _ in range(R)]
for r in range(R):
    for c in range(C):
        if third_board[r][c] == 'O':
            first_board[r][c] = '.'
            for dr, dc in zip(drs, dcs):
                nr, nc = r+dr, c+dc
                if 0 > nr or nr >= R or 0 > nc or nc >= C:
                    continue
                else:
                    first_board[nr][nc] = '.'


if N == 1:
    for lst in board:
        print(''.join(lst))
elif N % 2 == 0:
    for _ in range(R):
        print("O"*C)
elif N % 4 == 1:
    for lst in first_board:
        print(''.join(lst))
else:
    for lst in third_board:
        print(''.join(lst))