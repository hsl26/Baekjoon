N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]

def case1(b, c):
    cnt = 0
    std = [['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']]
    for r in range(0, 8, 2):
        for i in range(c, c+8):
            if b[r][i] != std[0][i-c]:
                cnt += 1
            if b[r+1][i] != std[1][i-c]:
                cnt += 1
    return cnt


def case2(b, c):
    cnt = 0
    std = [['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']]
    for r in range(0, 8, 2):
        for i in range(c, c + 8):
            if b[r][i] != std[0][i - c]:
                cnt += 1
            if b[r + 1][i] != std[1][i - c]:
                cnt += 1
    return cnt


min_ans = N*M
for r in range(N+1-8):
    for c in range(M+1-8):
        tmp = board[r:r+8]
        ans1 = case1(tmp, c)
        ans2 = case2(tmp, c)
        ans = min(ans1, ans2)
        if ans < min_ans:
            min_ans = ans

print(min_ans)