N = int(input())

for i in range(N):
    for blank in range(i):
        print(' ', end='')
    for star in range(N-i):
        print('*', end='')
    print()