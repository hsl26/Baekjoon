N = int(input())
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

ans = 0
for i in arr:
    if N >= 10 ** i:
        ans += i * (10 ** i - 10 ** (i - 1))
    else:
        ans += i * (N - 10 ** (i - 1) + 1)
        break
print(ans)