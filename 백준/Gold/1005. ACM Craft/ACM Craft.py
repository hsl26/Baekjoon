import sys
input = sys.stdin.readline

T = int(input())


def kahn(adj_lst, time_lst):
    n = len(adj_lst)
    DP = [0 for _ in range(n)]

    d = [0] * n
    for u in range(n):
        for v in adj_lst[u]:
            d[v] += 1

    S = []
    for u in range(n):
        if d[u] == 0:
            S.append(u)
            DP[u] = time_lst[u]
    while S:
        u = S.pop(0)

        for v in adj_lst[u]:
            d[v] -= 1
            DP[v] = max(DP[u]+time[v], DP[v])
            if d[v] == 0:
                S.append(v)

    return DP


for _ in range(T):
    # 입력
    N, K = map(int, input().split())
    time = list(map(int, input().split()))
    adj = [[] for _ in range(N)]
    for _ in range(K):
        X, Y = map(int, input().split())
        adj[X-1].append(Y-1)
    W = int(input())

    # Topological Sorting
    dp = kahn(adj, time)

    print(dp[W-1])