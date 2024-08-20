sum, sub = list(map(int, input().split()))

win = (sum+sub)//2
los = sum - win

if win<0 or los<0 or win*2!=sum+sub or sum<sub:
    print(-1)
else:
    print(win, los)