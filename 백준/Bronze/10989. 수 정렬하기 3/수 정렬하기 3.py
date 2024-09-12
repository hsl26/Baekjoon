import sys
input = sys.stdin.readline

N = int(input())
nums = [0]*10001

for _ in range(N):
    num = int(input())
    nums[num] += 1

for i in range(10001):
    if nums[i] != 0:
        for _ in range(nums[i]):
            print(i)