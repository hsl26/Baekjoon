min_score = list(map(int, input().split()))
man_score = list(map(int, input().split()))

S = min_score[0] + min_score[1] + min_score[2] + min_score[3]
T = man_score[0] + man_score[1] + man_score[2] + man_score[3]

print(S if S>=T else T)