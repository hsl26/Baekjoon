n = int(input())
dic = {}
for _ in range(n):
    name, log = map(str, input().split())
    if log == "enter":
        dic[name] = 1
    if log == "leave":
        dic[name] = 0

arr = []
for key in dic:
    if dic[key]==1:
        arr.append(key)
arr.sort(reverse=True)
for a in arr:
    print(a)