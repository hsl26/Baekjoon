# 이동 방향
direction = {"R": (0, 1), "L": (0, -1), "B": (1, 0), "T": (-1, 0),
             "RT": (-1, 1), "LT": (-1, -1), "RB": (1, 1), "LB": (1, -1)}

# 킹의 위치, 돌의 위치, 움직이는 횟수
K, R, N = map(str, input().split())
N = int(N)

King = (8-int(K[1]), ord(K[0])-ord('A'))
Rock = (8-int(R[1]), ord(R[0])-ord('A'))

for _ in range(N):
    d = input()

    dr, dc = direction[d]
    nKr, nKc = King[0] + dr, King[1] + dc
    nRr, nRc = Rock[0] + dr, Rock[1] + dc

    # 킹이 체스판 밖으로 나갈 때
    if 0 > nKr or nKr >= 8 or 0 > nKc or nKc >= 8:
        continue

    # 킹이 돌과 같은곳으로 이동할 때
    if (nKr, nKc) == Rock:
        # 돌이 체스판 밖으로 나갈 때
        if 0 > nRr or nRr >= 8 or 0 > nRc or nRc >= 8:
            continue
        King = (nKr, nKc)
        Rock = (nRr, nRc)
    else:
        King = (nKr, nKc)

print(chr(ord('A')+King[1]) + str(8-int(King[0])))
print(chr(ord('A')+Rock[1]) + str(8-int(Rock[0])))