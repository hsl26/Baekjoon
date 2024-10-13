N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

def dp(d, arr):
    if d == M:
        print(' '.join(arr))
        return

    for i in nums:
        if str(i) in arr:
            continue
        arr.append(str(i))
        dp(d+1, arr)
        arr.pop()

    return

dp(0, [])