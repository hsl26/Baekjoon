N, M = map(int, input().split())
board = list(list(map(int, input().split())) for _ in range(N))
K = int(input())

for _ in range(K):
    i, j, x, y = map(int, input().split())
    ans = 0
    for r in range(i-1, x):
        ans += sum(board[r][j-1:y])
    print(ans)