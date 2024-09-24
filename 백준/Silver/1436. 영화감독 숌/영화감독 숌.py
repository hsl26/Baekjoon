N = int(input())
cur = 665

while True:
    if N == 0:
        print(cur)
        break
    cur += 1
    if '666' in str(cur):
        N -= 1
    