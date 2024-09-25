N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

ans = A+B
ans.sort()
for a in ans:
    print(a, end=' ')