N = int(input())


def print_star(i):
    for blank in range(N-i):
        print(" ", end="")
    for star in range(2*i-1):
        print("*", end="")


for i in range(1, N+1):
    print_star(i)
    print()

for i in range(N-1, 0, -1):
    print_star(i)
    if i != 1:
        print()