T = int(input()) # 테스트 케이스
for _ in range(T):
    n = int(input()) # 해빈이가 가진 의상의 수
    closet = {}
    for _ in range(n):
        name, type = map(str, input().split()) # 의상의 이름과 의상의 종류
        try:
            closet[type] += 1
        except:
            closet[type] = 1

    ans = 1
    for key, item in closet.items():
        ans *= (item+1)

    print(ans-1)