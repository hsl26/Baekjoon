A, B, C = map(int, input().split())

if B >= C:
    print(-1)
else:
    profit = C - B
    print(A // profit + 1)