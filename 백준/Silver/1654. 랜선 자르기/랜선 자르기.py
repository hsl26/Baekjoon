K, N = map(int, input().split())
cable = [int(input()) for _ in range(K)]

total_cable = sum(cable)
i, j = 1, max(cable)
mid = (i+j) // 2

ans = 0
while True:
    if i > j:
        break
    cnt = 0
    for c in cable:
        cnt += c // mid

    if cnt < N:
        j = mid - 1
    elif cnt >= N:
        i = mid + 1

    mid = (i+j) // 2

print(mid)