T = int(input())


def find(a, b):
    while True:
        a, b = b, a%b
        if b == 0:
            break
    return a


for _ in range(T):
    A, B = map(int, input().split())
    print(A*B//find(A, B))