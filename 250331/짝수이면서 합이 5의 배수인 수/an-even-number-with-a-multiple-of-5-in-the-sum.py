n = int(input())

# Please write your code here.
def plus(num):
    return num//10 + num%10

def return_result(num):
    if num%2 == 0:
        if plus(num)%5 ==0:
            return("Yes")
    return("No")

print(return_result(n))