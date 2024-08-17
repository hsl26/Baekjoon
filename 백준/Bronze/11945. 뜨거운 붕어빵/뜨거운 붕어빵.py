N, M = list(map(int, input().split()))

fish = [list(input()) for _ in range(N)]

new_fish = fish.copy()

for n in range(N):
    new_fish[n] = fish[n].copy()
    for m in range(M):
        new_fish[n][m] = fish[n][M-m-1]

for n in range(N):
    print(''.join(new_fish[n]))