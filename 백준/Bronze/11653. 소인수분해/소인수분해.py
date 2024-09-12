N = int(input())

d = 2
while True:
    if N == 1:
        break
    if N % d == 0:
        print(d)
        N /= d
    else:
        d += 1