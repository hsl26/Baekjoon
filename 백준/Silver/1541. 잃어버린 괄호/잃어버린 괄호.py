equation = list(map(str, input().split('-')))

ans = 0
for i in range(len(equation)):
    lst = list(map(int, equation[i].split('+')))
    if i == 0:
        ans += sum(lst)
    else:
        ans -= sum(lst)

print(ans)