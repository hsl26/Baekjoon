N = int(input())
have = list(map(int, input().split()))

card = {}
for h in have:
    card[h] = 1

M = int(input())
is_have = list(map(int, input().split()))

for i in is_have:
    try:
        print(card[i], end=' ')
    except:
        print(0, end=' ')
