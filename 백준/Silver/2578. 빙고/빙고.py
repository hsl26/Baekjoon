bingo = [list(map(int, input().split())) for _ in range(5)]
visited = [[0]*5 for _ in range(5)]
call = []
for _ in range(5):
    call += list(map(int, input().split()))

def BINGO(visited):
    cnt = 0
    # 가로빙고
    for r in range(5):
        if sum(visited[r]) == 5:
            cnt += 1
    # 세로빙고
    for c in range(5):
        if visited[0][c] == visited[1][c] == visited[2][c] == visited[3][c] == visited[4][c] == 1:
            cnt += 1
    # 대각선빙고
    if visited[0][0] == visited[1][1] == visited[2][2] == visited[3][3] == visited[4][4] == 1:
        cnt += 1
    if visited[0][4] == visited[1][3] == visited[2][2] == visited[3][1] == visited[4][0] == 1:
        cnt += 1
    return cnt


for idx, num in enumerate(call):
    for r in range(5):
        if num in bingo[r]:
            c = bingo[r].index(num)
            visited[r][c] = 1
            break

    if BINGO(visited) >= 3:
        print(idx+1)
        break