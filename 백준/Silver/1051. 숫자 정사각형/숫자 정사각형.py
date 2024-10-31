N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
ans = 0
for length in range(min(N, M)):
        for r in range(N-length):
            for c in range(M-length):
                if board[r][c] == board[r+length][c] == board[r][c+length] == board[r+length][c+length]:
                    ans = max(ans, (length+1)*(length+1))
print(ans)