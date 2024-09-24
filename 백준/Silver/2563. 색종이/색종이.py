N = int(input())
board = [[0 for _ in range(100)] for _ in range(100)]


def black(R, C):
    for r in range(R, R+10):
        for c in range(C, C+10):
            board[r][c] = 1


for _ in range(N):
    r, c = map(int, input().split())
    black(r, c)

ans = 0
for line in board:
    ans += sum(line)
print(ans)