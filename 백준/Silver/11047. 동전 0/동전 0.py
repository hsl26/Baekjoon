N, K = map(int, input().split())
A = [int(input()) for _ in range(N)]

ans = 0
for i in range(N-1, -1, -1):
    if K == 0:
        break
    if K < A[i]:
        continue
    ans += K//A[i]
    K %= A[i]

print(ans)