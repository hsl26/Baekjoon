T = int(input())

dir = [1, 2, 3]

def dfs(n):
    global cnt
    if n <= 0:
        if n == 0:
            cnt += 1
        return

    for d in dir:
        dfs(n - d)

    return


for _ in range(T):
    n = int(input())
    cnt = 0
    dfs(n)
    print(cnt)