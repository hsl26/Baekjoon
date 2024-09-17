N, M = map(int, input().split())
arr = [N*M]
ans = 0
idx = 0

while True:
    if len(arr) == N*M:
        break
    cur = arr[idx]
    if cur == 1:
        idx += 1
        continue
    arr.remove(cur)
    ans += 1
    arr.append(cur//2)
    arr.append(cur - cur//2)

print(ans)