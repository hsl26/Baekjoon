import sys
input = sys.stdin.readline

T = int(input())


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

    if not S:
        return "IMPOSSIBLE"

    while S:
        u = S.pop()
        result.append(str(u+1))

        for v in adj[u]:
            d[v] -= 1
            if d[v] == 0:
                S.append(v)

    if len(result) != n:
        return "IMPOSSIBLE"
    
    result = ' '.join(result)
    return result


for _ in range(T):
    n = int(input())

    last_rank = list(map(int, input().split()))
    adj = [[] for _ in range(n)]
    for u in range(n):
        for v in range(u+1, n):
            adj[last_rank[u]-1].append(last_rank[v]-1)

    m = int(input())
    for _ in range(m):
        a, b = map(int, input().split())
        last_a = last_rank.index(a)
        last_b = last_rank.index(b)
        if last_a <= last_b:
            adj[b - 1].append(a - 1)
            adj[a-1].remove(b-1)
        else:
            adj[a - 1].append(b - 1)
            adj[b-1].remove(a-1)

    res = kahn(adj)

    print(res)