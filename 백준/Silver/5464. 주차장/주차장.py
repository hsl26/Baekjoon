# 시내 주차장은 1부터 N까지 번호가 매겨진 N개의 주차 공간
N, M = map(int, input().split())
Rs = [int(input()) for _ in range(N)]
Wk = [int(input()) for _ in range(M)]
K_order = [int(input()) for _ in range(2*M)]
# 매일 아침 모든 주차 공간이 비어 있는 상태
# 대기장소는 큐(queue)
parking = [0] * N
waiting = []

ans = 0
for k in K_order:
    if k < 0:
        k = -1*k
        idx = parking.index(k)
        parking[idx] = 0
        
        # 주차료는 차랑의 무게에다 주차 공간마다 따로 책정된 단위 무게당 요금을 곱한 가격
        ans += Wk[k - 1] * Rs[idx]
    else:
        waiting.append(k)

    # 차가 주차장에 도착하면, 주차장 관리인이 비어있는 주차 공간이 있는지를 검사
    # 만일 비어있는 공간이 없으면, 차량을 빈 공간이 생길 때까지 입구에서 기다리게
    # 여러 대의 차량이 도착하면,
    # 일단 도착한 순서대로 입구의 대기장소에서 줄을 서서 기다려
    if parking.count(0) != 0 and waiting:
        # 만일 빈 주차 공간이 하나만 있거나
        # 또는 빈 주차 공간이 없다가 한 대의 차량이 주차장을 떠나면
        # 곧바로 그 장소에 주차

        # 만일 빈 주차 공간이 여러 곳이 있으면, 그 중 번호가 가장 작은 주차 공간에 주차
        idx = parking.index(0)
        parking[idx] = waiting[0]
        waiting.pop(0)


print(ans)