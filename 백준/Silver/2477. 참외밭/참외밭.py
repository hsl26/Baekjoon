K = int(input())
corner = {1:[], 2:[], 3:[], 4:[]}

# 2(3, 2), 4(2, 4)
# 3(1, 3), 1(4, 1)
# sub = [(0, 0), (4, 1), (3, 2), (1, 3), (2, 4)]
# sub1, sub2 = -1, -1
corners = []
for _ in range(6):
    c, length = map(int, input().split())
    corner[c].append(length)
    corners.append(length)

h = max(corner[3]+corner[4]) # 가로
v = max(corner[1]+corner[2]) # 세로
area = h*v

h_idx = corners.index(h)
v_idx = corners.index(v)

sub_h = corner[3]+corner[4]
sub_v = corner[1]+corner[2]
sub_v.remove(corners[(h_idx-1)%6])
sub_v.remove(corners[(h_idx+1)%6])
sub_h.remove(corners[(v_idx-1)%6])
sub_h.remove(corners[(v_idx+1)%6])
sub_area = sub_h[0] * sub_v[0]

AREA = area-sub_area # 큰네모 - 작은네모
print(AREA*K)