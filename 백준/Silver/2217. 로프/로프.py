N = int(input())
arr = [int(input()) for _ in range(N)]
arr.sort(reverse=True)

ans = 0
for i in range(1, N+1):
    if arr[i-1]*i > ans:
        ans = arr[i-1] * i

print(ans)