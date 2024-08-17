ax, ay, az = list(map(int, input().split()))
cx, cy, cz = list(map(int, input().split()))

bz = cz - ax
by = cy//ay
bx = cx - az

print(bx, by, bz)