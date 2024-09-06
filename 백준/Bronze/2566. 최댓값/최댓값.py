arr = [list(map(int, input().split())) for _ in range(9)]

max_num = -1
max_xy = [0, 0]
for i in range(9):
    current_max = max(arr[i])
    if current_max > max_num:
        max_num = current_max
        max_xy = [i+1, arr[i].index(current_max)+1]

print(max_num)
print(max_xy[0], max_xy[1])