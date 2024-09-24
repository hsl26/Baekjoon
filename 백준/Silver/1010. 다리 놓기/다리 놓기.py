def factorial(n):
    if n > 1:
        return n * factorial(n-1)
    else:
        return 1

T = int(input())
for _ in range(T):
    N, M= map(int, input().split())
    N, M = max(N, M), min(N, M)
    ans = factorial(N)//(factorial(N-M)*factorial(M))
    print(ans)
    