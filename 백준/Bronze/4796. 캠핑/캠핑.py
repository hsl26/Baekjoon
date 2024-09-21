it = 1
while True:
    L, P, V = map(int, input().split())
    if [L, P, V] == [0, 0, 0]:
        break
    last = V%P%L if V%P < L else L
    ans = V//P*L + last
    print(f'Case {it}: {ans}')
    it += 1