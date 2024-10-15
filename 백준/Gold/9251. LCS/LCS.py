A = list(input())
B = list(input())

DP = [[0]*len(B) for _ in range(len(A))]
if A[0] == B[0]:
    DP[0][0] = 1

def initialize():
    for a in range(1, len(A)):
        DP[a][0] = max(1, DP[a-1][0]) if A[a] == B[0] else DP[a-1][0]

    
    for b in range(1, len(B)):
        DP[0][b] = max(1, DP[0][b-1]) if A[0] == B[b] else DP[0][b-1]

initialize()

for a in range(1, len(A)):
    for b in range(1, len(B)):
        if A[a] == B[b]:
            DP[a][b] = max(DP[a-1][b-1]+1, DP[a-1][b], DP[a][b-1])
        else:
            DP[a][b] = max(DP[a-1][b], DP[a][b-1])
        
print(DP[len(A)-1][len(B)-1])