import sys
input = sys.stdin.readline

N = int(input())
nums = [int(input()) for _ in range(N)]
sort_nums = nums.copy()
sort_nums.sort()

sum_nums = sum(nums)
avg_under = sum_nums // N
avg = sum_nums / N
if avg - avg_under >= 0.5:
    ans1 = avg_under + 1
else:
    ans1 = avg_under

ans2 = sort_nums[N//2]

max_cnt = 0
flg = 1
ans3 = sort_nums[0]
num_dict = {}
set_nums = set(sort_nums)
for i in set_nums:
    num_dict[i] = 0
for n in sort_nums:
    num_dict[n] += 1

num_lst = sorted(num_dict.items(), key=lambda x:(-x[1], x[0]))

ans3 = num_lst[0][0]
if N != 1:
    if num_lst[0][1] == num_lst[1][1]:
        ans3 = num_lst[1][0]

ans4 = sort_nums[-1] - sort_nums[0]

print(ans1)
print(ans2)
print(ans3)
print(ans4)