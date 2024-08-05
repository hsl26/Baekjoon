r1 = int(input())
r2 = int(input())
r3 = int(input())

if r1 == r2 == r3:
    print('Equilateral')
elif r1 + r2 + r3 != 180:
    print('Error')
elif r1 == r2 or r2 == r3 or r3 == r1:
    print('Isosceles')
else:
    print('Scalene')