n = int(input())
dir_list = [list(input()) for _ in range(n)]
ans = [0 for _ in range(len(dir_list[0]))]

for c in range(len(dir_list[0])):
    arr = [0 for _ in range(n)]
    for r in range(n):
        arr[r] = dir_list[r][c]

    if len(list(set(arr))) == 1:
        ans[c] = arr[0]
    else:
        ans[c] = '?'

print(''.join(ans))