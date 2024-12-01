N, M = map(int, input().split())
adj = [[] for _ in range(N)]
for _ in range(M):
    A, B = map(int, input().split())
    adj[A-1].append(B-1)

def kahn(adj):
    n = len(adj)
    result = []

    # 진입 간선 수 count
    d = [0] * n
    for u in range(n):
        for v in adj[u]:
            d[v] += 1

    # 진입 간선 없는 애들 stack에 넣음
    S = []
    for u in range(n):
        if d[u] == 0:
            S.append(u)

    while len(S) != 0:
        u = S.pop()
        result.append(str(u+1))

        for v in adj[u]:
            d[v] -= 1
            if d[v] == 0:
                S.append(v)

    return result

res = kahn(adj)
print(' '.join(res))