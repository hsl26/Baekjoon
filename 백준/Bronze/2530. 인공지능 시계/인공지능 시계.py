clock = list(map(int, input().split()))
cook = int(input())

cook_time = []
cook_time.append(cook // 3600)
cook -= cook_time[0]*3600
cook_time.append(cook // 60)
cook_time.append(cook - cook_time[1]*60)

for i in range(3):
    clock[i] += cook_time[i]

for i in range(2,0,-1):
    if clock[i] >= 60:
        tmp = clock[i] // 60
        clock[i] %= 60
        clock[i-1] += tmp

if clock[0] >= 24:
    clock[0] %= 24

for i in range(3):
    print(clock[i], end=' ')