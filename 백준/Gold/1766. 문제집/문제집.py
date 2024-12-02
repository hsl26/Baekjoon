import sys
input = sys.stdin.readline

N, M = map(int, input().split())
adj = [[] for _ in range(N)]
for _ in range(M):
    A, B = map(int, input().split())
    adj[A-1].append(B-1)

def kahn(adj):
    n = len(adj)
    result = []

    d = [0] * n
    for u in range(n):
        for v in adj[u]:
            d[v] += 1

    S = []
    for u in range(n):
        if d[u] == 0:
            S.append(u)

    while S:
        min_num = min(S)
        min_idx = S.index(min_num)
        u = S.pop(min_idx)
        result.append(str(u+1))

        for v in adj[u]:
            d[v] -= 1
            if d[v] == 0:
                S.append(v)

    return result

ans = kahn(adj)

print(' '.join(ans))