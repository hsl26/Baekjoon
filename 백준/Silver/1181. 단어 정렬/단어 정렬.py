N = int(input())
s = set()

for _ in range(N):
    s.add(input())

s = list(s)
s.sort()
s.sort(key=lambda x: len(x))

print('\n'.join(s))