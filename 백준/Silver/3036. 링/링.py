N = int(input())
radius = list(map(int, input().split()))


def GCD(a, b):
    while b>0:
        a, b = b, a%b
    return a


A, B = 1, 1
for i in range(1, N):
    A *= radius[i-1]
    B *= radius[i]
    gcd = GCD(max(A, B), min(A, B))
    A = A // gcd
    B = B // gcd
    print(f'{A}/{B}')