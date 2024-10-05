S = input()
len_S = len(S)

arr = []
for i in range(len_S):
    arr.append(S[i:])

arr.sort()

for a in arr:
    print(a)