N, M = map(int, input().split())
def recursion(d, arr):
    global ans
    if d == M:
        print(' '.join(arr))
        return
    for i in range(1, N+1):
        if str(i) not in arr:
            arr.append(str(i))
            recursion(d+1, arr)
            arr.pop()
    return

recursion(0, [])