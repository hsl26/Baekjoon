H, W = map(int, input().split())
board = list(map(int, input().split()))

right = [board[0]]
for i in range(1, W):
    right.append(max(board[i], max(right)))

left = [board[-1]]
for i in range(W-2, -1, -1):
    left.append(max(board[i], max(left)))
left.reverse()

ans = 0
for i in range(W):
    ans += min(right[i], left[i]) - board[i]

print(ans)
