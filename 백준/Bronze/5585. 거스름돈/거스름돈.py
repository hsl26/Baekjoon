cost = 1000 - int(input())
Yen = [500, 100, 50, 10, 5, 1]

ans = 0
for yen in Yen:
    cnt = cost // yen
    cost = cost - cnt*yen
    ans += cnt

print(ans)