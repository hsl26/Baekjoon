a, b = map(int, input().split())

# Please write your code here.
def if_369(num):
    if num%3==0:
        return 1
    else:
        if '3' in str(num) or '6' in str(num) or '9' in str(num):
            return 1
    return 0

result = 0
for n in range(a, b+1):
    result += if_369(n)
print(result)