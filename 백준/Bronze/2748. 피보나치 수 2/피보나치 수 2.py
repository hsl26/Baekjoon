n = int(input())

fibo = [0, 1]


for i in range(n-1):
    fibo.append(fibo[i] + fibo[i+1])

print(fibo[-1])
