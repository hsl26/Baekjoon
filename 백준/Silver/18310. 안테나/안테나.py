N = int(input())
house = list(map(int, input().split()))

house.sort()

s = len(house)//2 if len(house) % 2 == 1 else len(house)//2-1
res = 100000 * 200001
for i in range(len(house) // 2):
    an1 = s - i
    an2 = s + i

    cal1 = 0
    cal2 = 0
    for a in house:
        cal1 += abs(a - house[an1])
        cal2 += abs(a - house[an2])

    # print(res, s, an1, cal1, an2, cal2)

    if cal1 < res:
        s = an1
        res = cal1

    if cal2 < res:
        s = an2
        res = cal2

    if s != an1 and s != an2:
        break

print(house[s])