T = int(input())

for _ in range(T):
    H, W, N = map(int, input().split())

    floor = str(N % H if N % H != 0 else H)

    room = N // H + 1 if N % H != 0 else N // H

    if room < 10:
        room = '0'+str(room)
    else:
        room = str(room)

    print(floor+room)