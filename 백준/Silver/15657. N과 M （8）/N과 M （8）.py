N, M = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

def bt(d, idx, arr):
    if d == M:
        print(' '.join(arr))
        return
    for i in range(idx, N):
        arr.append(str(lst[i]))
        bt(d+1, i, arr)
        arr.pop()

bt(0, 0, [])