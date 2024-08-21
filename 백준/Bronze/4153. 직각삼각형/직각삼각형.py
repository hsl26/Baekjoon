while True:
    a, b, c = map(int, input().split())
    if a==0 and b==0 and c==0:
        break

    MAX = max(a, b, c)
    MIN = min(a, b, c)
    MID = a+b+c - MAX - MIN
    if MIN**2+MID**2 == MAX**2:
        print("right")
    else:
        print("wrong")