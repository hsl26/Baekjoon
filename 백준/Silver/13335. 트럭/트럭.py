# n은 다리를 건너는 트럭의 수, w는 다리의 길이, 그리고 L은 다리의 최대하중
n, w, L = map(int, input().split())
trucks = list(map(int, input().split()))

ans = 0 # 시간
bridge = [0]*w # 다리. 초기는 비어 있음

while trucks: # 마지막 트럭이 다리에 올라가면 끝
    ans += 1
    if sum(bridge[1:]) + trucks[0] <= L: # (다리의 1번째~마지막 트럭 무게 합 + 다음에 올 트럭 무게) < 하중
        bridge.pop(0)
        bridge.append(trucks[0])
        trucks.pop(0)
    else:
        bridge.pop(0)
        bridge.append(0)

print(ans+w) # 마지막 트럭이 다리에서 벗어나려면 다리 길이만큼 시간이 필요하니까 +w