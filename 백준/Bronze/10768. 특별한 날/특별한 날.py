month = int(input())
day = int(input())

if month == 2 and day == 18:
    print("Special")
elif (month == 2 and day > 18) or month > 2:
    print("After")
else:
    print("Before")