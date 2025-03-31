y = int(input())

# Please write your code here.
def result(year):
    if year%4 == 0:
        if year%100 == 0 and year%400 != 0:
            return False
        return True
    return False

if result(y):
    print("true")
else:
    print("false")