N, M = map(int, input().split())

def recursion(d, arr):
    if d == M:
        print(' '.join(arr))
        return
    for i in range(1, N+1):
        if d != 0 and int(arr[-1]) > i:
            continue
        arr.append(str(i))
        recursion(d+1, arr)
        arr.pop()

recursion(0, [])