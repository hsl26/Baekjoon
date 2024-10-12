N, M = map(int, input().split())

def bT(d, arr):
    if d == M:
        print(' '.join(arr))
        return

    for i in range(1, N+1):
        arr.append(str(i))
        bT(d+1, arr)
        arr.pop()

    return

bT(0, [])