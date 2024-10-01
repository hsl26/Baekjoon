N = int(input())
N_card = list(map(int, input().split()))
M = int(input())
M_card = list(map(int, input().split()))

have = {}
for card in M_card:
    have[card] = 0

for card in N_card:
    try:
        have[card] += 1
    except:
        continue

for card in M_card:
    print(have[card], end=' ')