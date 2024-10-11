T = int(input())
# 조규현 좌표: (x1, y1), 조규현-류재명: r1, 백승환 좌표: (x2, y2), 백승황-류재명: r2
for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    R = (x1-x2)**2 + (y1-y2)**2

    if r1==r2 and x1==x2 and y1==y2:
        print(-1)
    # 두 점에서 만나는 경우
    elif (r1 - r2) ** 2 < R < (r1 + r2) ** 2:
        print(2)
    # 한 점에서 만나는 경우 2가지
    elif (r1 - r2) ** 2 == R or (r1 + r2) ** 2 == R:
        print(1)
    # 만나지 않는 경우
    elif (r1 - r2) ** 2 > R or (r1 + r2) ** 2 < R:
        print(0)