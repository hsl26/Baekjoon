N = int(input())
card = [str(i) for i in range(1, N+1)]

del_card = []
while True:
    if len(card) == 1:
        break
    del_card += [card[0]]
    card += [card[1]]
    card = card[2:]

del_card += card
print(' '.join(del_card))