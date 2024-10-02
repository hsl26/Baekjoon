N, M = map(int, input().split())
pocket = [input() for i in range(N)]
pocket_dict = {}
for idx, p in enumerate(pocket):
    pocket_dict[p] = idx

for _ in range(M):
    question = input()
    if question.isdigit():
        print(pocket[int(question)-1])
    else:
        print(pocket_dict[question]+1)