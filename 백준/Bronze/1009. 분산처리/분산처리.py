T = int(input())

for _ in range(T):
    a, b = map(int, input().split())

    set_num = b
    remain = []
    for i in range(1, b+1):
        remain.append((a ** i) % 10)
        if len(remain) != len(list(set(remain))):
            set_num = len(list(set(remain)))
            break

    new_b = b % set_num if b % set_num != 0 else set_num
    data_cnt = a ** new_b

    ans = data_cnt % 10 if data_cnt % 10 != 0 else 10
    print(ans)