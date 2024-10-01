N = int(input())
N_card = list(map(int, input().split()))
M = int(input())
M_card = list(map(int, input().split()))

have = {}
for card in N_card:
    try:
        have[card] += 1
    except:
        have[card] = 1

for card in M_card:
    try:
        print(have[card], end=' ')
    except:
        print(0, end=' ')