N, M = map(int, input().split())

B = [0 for _ in range(N)]

for _ in range(M):
    i, j, k = map(int, input().split())
    for b in range(i-1, j):
        B[b] = k

for b in range(N):
    print(B[b], end=' ')