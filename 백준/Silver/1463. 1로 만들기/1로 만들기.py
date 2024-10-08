N = int(input())

dir = [1, 2, 3]
def cal(n, d):
    if d == 1:
        return n-1
    elif d == 2:
        return n // 2
    else:
        return n // 3


def can_go(n, nn):
    if 0 > nn:
        return False
    if step[nn] != 0 and step[n]+1 >= step[nn]:
        return False
    return True


def bfs():
    global q
    while q:
        n = q.pop(0)
        for d in dir:
            if n % d != 0:
                continue
            nn = cal(n, d)
            if can_go(n, nn):
                q.append(nn)
                step[nn] = step[n]+1

        if step[1] != 0:
            break


step = [0] * (10 ** 6 + 1)
q = []
q.append(N)
step[N] = 0
bfs()

print(step[1])