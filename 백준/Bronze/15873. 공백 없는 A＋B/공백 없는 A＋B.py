AB = list(input())

if AB[1] == '0':
    A = int(''.join(AB[:2]))
    B = int(''.join(AB[2:]))
elif len(AB) == 3:
    A = int(AB[0])
    B = int(''.join(AB[1:]))
else:
    A = int(AB[0])
    B = int(AB[1])

print(A+B)