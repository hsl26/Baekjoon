T = int(input())

for t in range(1, T+1):
    x, y = map(int, input().split())

    len = y - x
    cnt = 0

    for i in range(1, len + 1):
        cal = i * (1 + i)

        if cal > len:
            n = i - 1
            len = len - cal + 2 * i

            cnt += 2 * n + len // i

            if len % i != 0:
                cnt += 1

            break

    print(cnt)