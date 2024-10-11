import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
lst = [list(map(int, input().split())) for _ in range(M)]

sum = 0
for i in range(N):
    sum += arr[i]
    arr[i] = sum

for i, j in lst:
    if i == 1:
        print(arr[j-1])
    else:
        print(arr[j-1] - arr[i-2])