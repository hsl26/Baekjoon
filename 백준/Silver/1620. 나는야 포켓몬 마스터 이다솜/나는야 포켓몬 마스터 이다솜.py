N, M = map(int, input().split())
pocket = [input() for i in range(N)]
pocket_dict = {}
for idx, p in enumerate(pocket):
    pocket_dict[p] = idx

for _ in range(M):
    question = input()
    try:
        q = int(question)
        print(pocket[q-1])
    except:
        print(pocket_dict[question]+1)