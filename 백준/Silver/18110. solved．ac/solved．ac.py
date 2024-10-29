n = int(input())
arr = [int(input()) for _ in range(n)]
arr.sort()

r = n * 0.15
r = int(r // 1) if r // 1 + 0.5 > r else int(r // 1 + 1)

use_arr = arr[r:len(arr)-r]
if len(use_arr) == 0:
    avg = 0
else:
    avg = sum(use_arr) / len(use_arr)
    avg = int(avg // 1) if avg // 1 + 0.5 > avg else int(avg // 1 + 1)
print(avg)