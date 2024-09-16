arr = [list(input()) for _ in range(5)]

for c in range(15):
    for r in range(5):
        try:
            print(arr[r][c], end='')
        except IndexError:
            continue