N = int(input())
P = list(map(int, input().split()))

P.sort(reverse=True)
ans = [0]*N

for i in range(N):
    ans[i] = sum(P[i:])

print(sum(ans))