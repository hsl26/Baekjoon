X = int(input())
stick = [64]

while True:
    if sum(stick) == X:
        print(len(stick))
        break

    stick.sort(reverse=True)
    short = stick[-1]
    stick.pop()
    if short != 1 and sum(stick) + short//2 >= X:
        stick += [short//2]
    else:
        stick += [short//2, short//2]