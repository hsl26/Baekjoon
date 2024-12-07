def compute_pi(P):
    m = len(P)
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


while True:
    p = list(input())
    if p[0] == ".":
        break

    PI = compute_pi(p)

    if len(p) % (len(p) - PI[-1]) == 0:
        print(len(p) // (len(p) - PI[-1]))
    else:
       print(1)