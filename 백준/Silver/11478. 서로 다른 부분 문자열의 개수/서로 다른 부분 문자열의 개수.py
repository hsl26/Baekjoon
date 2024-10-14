S = list(input())

lenght = len(S)
sub_strs = []

for start in range(lenght):
    cur_S = S.copy()
    for end in range(1, lenght-start+1):
        sub_strs.append(''.join(cur_S))
        cur_S.pop()
    S.pop(0)

print(len(list(set(sub_strs))))