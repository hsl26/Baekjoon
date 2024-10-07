N = int(input())
M = int(input())
matter = list(map(int, input().split()))
matter.sort()

ans = 0
left, right = 0, N-1
while True:
    if left >= N or 0 > right or left >= right:
        break
    if matter[left] + matter[right] == M:
        ans += 1
        left += 1
        right -= 1
    elif matter[left] + matter[right] < M:
        left += 1
    else:
        right -= 1

print(ans)