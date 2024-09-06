T = int(input())
C = [int(input()) for _ in range(T)]

for c in C:
    Quarter = c // 25
    c = c - (25*Quarter)
    Dime = c // 10
    c = c - (10*Dime)
    Nickel = c // 5
    Penny = c - (5*Nickel)
    print(Quarter, Dime, Nickel, Penny)