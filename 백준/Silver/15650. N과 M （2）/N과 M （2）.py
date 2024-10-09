N, M = map(int, input().split())
def recursion(d, idx, arr):
    global ans
    if d == M:
        print(' '.join(arr))
        return
    for i in range(idx, N+1):
        arr.append(str(i))
        recursion(d+1, i+1, arr)
        arr.pop()
    return

recursion(0, 1, [])