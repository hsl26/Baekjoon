x, y = map(int, input().split())
day = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
date = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

total_date = sum(date[:x]) + y
print(day[total_date % 7])