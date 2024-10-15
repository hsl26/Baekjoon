n = int(input())
arr = list(map(int, input().split()))
score = arr.copy()

for i in range(1, n):
    score[i] = max(score[i], score[i-1]+arr[i])

print(max(score))