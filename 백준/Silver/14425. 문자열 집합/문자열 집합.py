N, M = map(int, input().split())
S = [input() for _ in range(N)]

ans = 0
for _ in range(M):
    word = input()
    if word in S:
        ans += 1

print(ans)