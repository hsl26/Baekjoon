N = int(input())
A = list(map(int, input().split()))

ans = [str(-1) for _ in range(N)]
curr = []

for i in range(N-1, -1, -1):
    # if len(curr) == 0:
    #     continue
    if len(curr) != 0:
        if curr[-1] > A[i]:
            ans[i] = str(curr[-1])

    # print(A[i], ans[i], curr, A[i-1])
    if A[i] > A[i-1]:
        curr += [A[i]]
    while len(curr) != 0 and A[i-1] >= curr[-1]:
        curr.pop()
    # print(A[i], ans[i], curr)
    # print()

print(' '.join(ans))
