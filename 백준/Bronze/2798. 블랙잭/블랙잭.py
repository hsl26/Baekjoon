N, M = map(int, input().split())
card = list(map(int, input().split()))

max_sum = 0
for a in range(len(card)-2):
    for b in range(a+1, len(card)-1):
        for c in range(b+1, len(card)):
            sum = card[a] + card[b] + card[c]
            if sum <= M and max_sum < sum:
                max_sum = sum

print(max_sum)