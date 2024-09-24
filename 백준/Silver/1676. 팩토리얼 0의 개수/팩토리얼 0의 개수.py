def factorial(n):
    if n > 1:
        return n * factorial(n-1)
    if n == 1:
        return 1
 
result = str(factorial(int(input())))
result = list(result)

idx = -1
if result[idx] != '0':
    print(0)
else:
    while True:
        if result[idx-1] != '0':
            print(-1*idx)
            break
        idx -= 1
