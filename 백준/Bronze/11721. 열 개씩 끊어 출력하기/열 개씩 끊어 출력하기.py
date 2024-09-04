N = input()

while True:
    if len(N) <= 10:
        print(N)
        break
    print(N[:10])
    N = N[10:]