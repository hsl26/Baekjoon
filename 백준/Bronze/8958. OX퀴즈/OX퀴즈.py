T = int(input())

for _ in range(T):
    OX = list(input().split('X'))

    ans = 0
    for ox in OX:
        if len(ox) != 0:
            ans += len(ox)*(1+len(ox)) // 2

    print(ans)