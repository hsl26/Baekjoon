N = int(input())
switch = list(map(int, input().split()))
n = int(input())

for i in range(N):
    if switch[i] == 0:
        switch[i] = -1

for _ in range(n):
    sex, num = map(int, input().split())
    if sex == 1: # 남자
        for i in range(num, N+1, num):
            switch[i-1] = -1 * switch[i-1]
    else: # 여자
        tmp = 0
        while True:
            if num-1-tmp < 0 or num-1+tmp >= N:
                break
            if switch[num-1-tmp] != switch[num-1+tmp]:
                break
            tmp += 1
        for i in range(num-1-(tmp-1), num-1+(tmp-1)+1):
            switch[i] = -1 * switch[i]

for i in range(N):
    if switch[i] == -1:
        switch[i] = '0'
    else:
        switch[i] = '1'

for i in range(0, N, 20):
    print(' '.join(switch[i:i+20]))