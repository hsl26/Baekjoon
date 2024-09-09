N, B = map(str, input().split())
B = int(B)

to_num = ord('A') - 10

ans = 0
for idx, n in enumerate(N):
    if ord(n) >= ord('A'):
        num = ord(n) - to_num
    else:
        num = int(n)

    ans += num * (B ** (len(N) - idx - 1))

print(ans)