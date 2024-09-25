S = input()

arr0 = S.split('0')
arr1 = S.split('1')

while True:
    if '' not in arr0:
        break
    arr0.remove('')

while True:
    if '' not in arr1:
        break
    arr1.remove('')

print(min(len(arr0), len(arr1)))