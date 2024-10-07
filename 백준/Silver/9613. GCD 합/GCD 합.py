t = int(input())


def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


def comb(d, idx, arr):
    global ans
    if d == 2:
        ans += gcd(max(arr), min(arr))
        return
    for i in range(idx, n):
        comb(d+1, i+1, arr+[gcds[i]])
    return


for _ in range(t):
    arr = list(map(int, input().split()))
    n = arr[0]
    gcds = arr[1:]
    ans = 0
    comb(0, 0, [])
    print(ans)