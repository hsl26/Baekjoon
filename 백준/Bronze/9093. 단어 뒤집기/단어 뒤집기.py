T = int(input())
for _ in range(T):
    arr = list(map(list, input().split()))
    ans = []
    for i in range(len(arr)):
        arr[i].reverse()
        ans.append(''.join(arr[i]))
    print(' '.join(ans))