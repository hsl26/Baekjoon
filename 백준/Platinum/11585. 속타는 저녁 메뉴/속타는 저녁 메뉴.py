def GCD(a, b):
    while b > 0:
        a, b = b, a%b
    return a

def compute_pi(P):
    m = len(P)
    pi = [0] * (m+1)
    i, j = 1, 0

    while i < m:
        if P[i] == P[j]:
            i += 1
            j += 1
            pi[i] = j
        elif j == 0:
            i += 1
            pi[i] = j
        else:
            j = pi[j]

    return pi

N = int(input())
meat = list(input().split())
roulette = list(input().split())
roulette += roulette[:-1]

pi = compute_pi(meat)

ans = 0
i, j = 0, 0
while i < len(roulette):
    if roulette[i] == meat[j]:
        i += 1
        j += 1

        if j == N:
            ans += 1
            j = pi[j]

    elif j == 0:
        i += 1
    else:
        j = pi[j]

gcd = GCD(ans, N)
print(f"{ans//gcd}/{N//gcd}")