N, M = map(int, input().split())
A = list(map(int, input().split()))
len_A = len(A)

ans = 0
left, right = 0, 0
sum = A[left]
while right < len_A:
    if sum == M:
        ans += 1
        left += 1
        right += 1
        if left == len_A or right == len_A:
            break
        sum = sum - A[left-1] + A[right]
    elif sum < M:
        right += 1
        if right == len_A:
            break
        sum += A[right]
    else:
        left += 1
        if left == len_A:
            break
        sum -= A[left-1]

print(ans)