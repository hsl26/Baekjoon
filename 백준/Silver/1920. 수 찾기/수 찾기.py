N = int(input())
A = list(map(int, input().split()))
M = int(input())
is_A = list(map(int, input().split()))

A_dict = {}
for a in A:
    A_dict[a] = 1

for i in is_A:
    try:
        print(A_dict[i])
    except:
        print(0)