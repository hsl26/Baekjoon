T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    order = [0]*N
    order[M] = 1

    sort_arr = arr.copy()
    sort_arr.sort(reverse=True)

    cnt = 0
    while True:
        if sort_arr[0] == arr[0]:
            cnt += 1
            if order[0] == 1:
                break
            sort_arr.pop(0)
            arr.pop(0)
            order.pop(0)
        else:
            arr.append(arr.pop(0))
            order.append(order.pop(0))

    print(cnt)