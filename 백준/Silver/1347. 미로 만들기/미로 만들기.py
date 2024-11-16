N = int(input())
lst = list(input())

# ‘F’는 앞으로 한 칸 움직인 것이고,
# ‘L'과 ’R'은 방향을 왼쪽 또는 오른쪽으로 전환한 것

drs, dcs =[1, 0, -1, 0], [0, -1, 0, 1]

r, c = 0, 0 # 시작 위치
d = 0 # 시작 방향

miro_coor_r = [r]
miro_coor_c = [c]
for l in lst:
    dr, dc = drs[d], dcs[d]
    if l == 'F':
        r, c = r+dr, c+dc
        miro_coor_r += [r]
        miro_coor_c += [c]
    elif l == 'R':
        d = (d+1)%4
    else:
        d = (d-1)%4

min_r = min(miro_coor_r)
min_c = min(miro_coor_c)

for i in range(len(miro_coor_r)):
    miro_coor_r[i] -= min_r
    miro_coor_c[i] -= min_c

miro = [['#']*(max(miro_coor_c)+1) for _ in range(max(miro_coor_r)+1)]

for r, c in zip(miro_coor_r, miro_coor_c):
    miro[r][c] = '.'

for lst in miro:
    print(''.join(lst))