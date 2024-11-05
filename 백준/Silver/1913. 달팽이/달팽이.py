N = int(input())
K = int(input())

num = 1 # 보드에 넣을 숫자
r, c = N // 2, N // 2
R, C = r, c # K 좌표

board = [[0]*N for _ in range(N)]
board[r][c] = str(num)

div = [(-1, 0), (0, 1), (1, 0), (0, -1)]
cnt = []
for i in range(1, N):
    cnt += [i, i]
cnt += [cnt[-1]]

for idx, ct in enumerate(cnt):
    d = idx % 4
    dr, dc = div[d]
    for _ in range(ct):
        r, c = r+dr, c+dc
        num += 1

        if num == K:
            R, C = r, c

        board[r][c] = str(num)


for lst in board:
    print(' '.join(lst))
print(R+1, C+1)