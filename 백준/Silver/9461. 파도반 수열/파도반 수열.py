T = int(input())
for _ in range(T):
    N = int(input())
    arr = [0] * (N if N > 5 else N+5)
    arr[0] = 1
    arr[1] = 1
    arr[2] = 1
    arr[3] = 2
    arr[4] = 2
    for i in range(5, N):
        arr[i] = arr[i-1] + arr[i-5]
    print(arr[N-1])