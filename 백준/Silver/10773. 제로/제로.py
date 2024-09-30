K = int(input())
ans = []

for _ in range(K):
    n = int(input())
    if n != 0:
        ans.append(n)
    else:
        ans.pop()
print(sum(ans))