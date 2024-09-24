def factorial(n):
    if n > 1:
        return n * factorial(n-1)
    if n == 1:
        return 1
 
result = str(factorial(int(input()))) + '0'
result = list(result)

idx = -1
while True:
    if result[idx-1] != '0':
        print(-1*(idx+1))
        break
    idx -= 1
