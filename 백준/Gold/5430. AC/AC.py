T = int(input())


def do(p, arr):
    idx = [0, 0, -1]
    flg = 1
    for i in range(len(p)):
        if p[i] == 'R':
            flg *= -1
        else:
            arr.pop(idx[flg])

    if P.count('R') % 2 == 1:
        arr.reverse()

    return '['+','.join(arr)+']'


for _ in range(T):
    P = list(input())
    n = int(input())
    lst = input()
    lst = lst[1:-1]
    if lst != '':
        lst = list(lst.split(','))
    else:
        lst = []

    if P.count('D') > len(lst):
        print('error')
    else:
        print(do(P, lst))