n = int(input())

# Please write your code here.
def plus(a, b):
    return (a+b)

sum = 0
for n in range(1, n+1):
    sum = plus(sum, n)
print(sum//10)