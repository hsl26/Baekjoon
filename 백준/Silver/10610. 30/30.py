N = list(input())
len_N = len(N)-1
ans = -1
sum_N = 0
for n in N:
    sum_N += int(n)

if '0' in N and sum_N % 3 == 0:
    N.sort(reverse=True)
    print(''.join(N))
else:
    print(ans)