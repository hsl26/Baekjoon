N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
ans = 0
for a in A:
    b = max(B)
    ans += a*b
    B.remove(b)

print(ans)