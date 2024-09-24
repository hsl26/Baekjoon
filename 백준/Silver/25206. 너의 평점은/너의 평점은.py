score = {'A+':4.5,'A0':4.0,'B+':3.5,'B0':3.0,'C+':2.5,'C0':2.0,'D+':1.5,'D0':1.0,'F':0.0, 'P':0.0}

sum = 0
total = 0

while True:
    try:
        name, num, s = input().split()
        num = int(num[0])
        sum += num
        total += num * score[s]
        if s == "P":
            sum -= num
    except:
        break

print(total/sum)