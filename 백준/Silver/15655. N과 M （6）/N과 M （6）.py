N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

def bt(d, idx, arr):
    if d == M:
        print(' '.join(arr))
        return

    for i in range(idx, N):
        arr.append(str(nums[i]))
        bt(d+1, i+1, arr)
        arr.pop()
    return

bt(0, 0, [])