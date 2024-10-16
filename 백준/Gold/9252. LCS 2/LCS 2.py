A = list(input())
B = list(input())

DP = [[0]*len(B) for _ in range(len(A))]
ST = [['']*len(B) for _ in range(len(A))]


if A[0] == B[0]:
    DP[0][0] = 1
    ST[0][0] = A[0]
# else:


def initialize():
    for a in range(1, len(A)):
        DP[a][0] = DP[a-1][0]
        ST[a][0] = ST[a - 1][0]
        if A[a] == B[0] and DP[a][0] == 0:
            DP[a][0] += 1
            ST[a][0] += A[a]

    for b in range(1, len(B)):
        DP[0][b] = DP[0][b-1]
        ST[0][b] = ST[0][b - 1]
        if A[0] == B[b] and DP[0][b] == 0:
            DP[0][b] += 1
            ST[0][b] += B[b]

initialize()

for a in range(1, len(A)):
    for b in range(1, len(B)):
        if A[a] == B[b]:
            DP[a][b] = DP[a-1][b-1] + 1
            ST[a][b] = ST[a-1][b-1] + A[a]
        else:
            if DP[a-1][b] > DP[a][b-1]:
                DP[a][b] = DP[a-1][b]
                ST[a][b] = ST[a-1][b]
            else:
                DP[a][b] = DP[a][b-1]
                ST[a][b] = ST[a][b-1]

print(DP[len(A)-1][len(B)-1])
if DP[len(A)-1][len(B)-1] != 0:
    print(ST[len(A) - 1][len(B) - 1])