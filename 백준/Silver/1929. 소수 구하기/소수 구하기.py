M, N = map(int, input().split())
nums = {i:True for i in range(1, N+1)}
nums[1] = False

for num in range(2, N+1):
    if nums[num]:
        for n in range(num, N+1, num):
            nums[n] = False
        nums[num] = True


for num in range(M, N+1):
    if nums[num]:
        print(num)