N, M, B = map(int, input().split())
board = []
for i in range(N):
    board += list(map(int, input().split()))

ans = []
# 놓는건 1초 제거는 2초
for h in range(min(board), max(board)+1):
    time = 0
    inven = B
    for b in board:
        if b < h: # 놓기
            time += (h-b)
            inven -= (h-b)
        elif b > h: # 제거하기
            time += 2 * (b-h)
            inven += (b-h)
    if inven >= 0:
        ans.append((time, h))

ans.sort(key=lambda x: (x[0], -1 * x[1]))
print(ans[0][0], ans[0][1])