N = int(input())
A = list(map(int, input().split()))
score = [1] * N

for i in range(N):
    for j in range(i):
        if A[j] < A[i]:
            score[i] = max(score[j] + 1, score[i])

print(max(score))