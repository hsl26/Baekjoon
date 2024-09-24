N = int(input())
person_arr = []

for i in range(1, N+1):
    person_arr.append([i] +list(map(str, input().split())))

arr = sorted(person_arr, key=lambda x:(int(x[1]), x[0]))

for num, age, name in arr:
    print(age, name)

