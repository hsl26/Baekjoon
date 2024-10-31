n = int(input())
student = []
for _ in range(n):
    name, day, month, year = map(str, input().split())
    student.append((name, int(year), int(month), int(day)))

student.sort(key=lambda x:(x[1], x[2], x[3]))
print(student[-1][0])
print(student[0][0])