N, K = map(int, input().split())
nums = [i for i in range(2, N+1)]
ans = 0

while True:
    p = nums[0]
    remove_nums = []
    for n in nums:
        if n % p == 0:
            remove_nums.append(n)
            K -= 1
        if K == 0:
            ans = remove_nums[-1]
            break
    if K == 0:
        break
    for r in remove_nums:
        nums.remove(r)

print(ans)