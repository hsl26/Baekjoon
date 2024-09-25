E, S, M = map(int, input().split())
ans = 1
while True:
    e = ans%15 if ans%15!=0 else 15
    s = ans%28 if ans%28!=0 else 28
    m = ans%19 if ans%19!=0 else 19

    if E==e and S==s and M==m:
        print(ans)
        break
    ans += 1