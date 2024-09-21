arr = [int(input()) for _ in range(10)]
ans = 0
it = 0
while True:
    if it == 10:
        break
    next = ans+arr[it]
    if next > 100:
        if 100 - ans >= next - 100:
            ans = next
        break
    ans = next
    it += 1
print(ans)