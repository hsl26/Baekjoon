L, P = list(map(int, input().split()))
paper = list(map(int, input().split()))

for idx in range(len(paper)):
    paper[idx] -= L*P

for p in paper:
    print(p, end=' ')