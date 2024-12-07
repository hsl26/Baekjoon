T = list(input())
P = list(input())

# 파이배열
def compute_pi(p):
    m = len(p)
    pi = [0] * (m+1)
    i, j = 1, 0

    while i < m:
        if p[i] == p[j]:
            i += 1
            j += 1
            pi[i] = j
        elif j == 0:
            i += 1
            pi[i] = j
        else:
            j = pi[j]

    return pi

PI = compute_pi(P)

n, m = len(T), len(P)
i, j = 0, 0

ans = []
while i < n:
    if T[i] == P[j]:
        i += 1
        j += 1

        if j == m: # 매치성공
            ans.append(str(i-j+1))
            j = PI[j]
    elif j == 0:
        i += 1
    else:
        j = PI[j]

print(len(ans))
if len(ans) != 0:
    print(' '.join(ans))
