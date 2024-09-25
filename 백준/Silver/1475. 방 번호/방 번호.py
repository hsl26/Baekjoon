N = list(input())
num = {0:0, 1:0, 2:0, 3:0, 4:0, 5:0, 6:0, 7:0, 8:0, 9:0}

for n in N:
    num[int(n)] += 1

num[6] += num[9]
num[9] = 0

ans = 0
for key in num:
    if key == 6:
        tmp = num[key]//2 if num[key]%2==0 else num[key]//2+1
        if tmp > ans:
            ans = tmp
    elif num[key] > ans:
        ans = num[key]

print(ans)