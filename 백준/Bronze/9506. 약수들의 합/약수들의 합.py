def is_perfect(num):
    arr = []
    arr_str = []
    for i in range(1, num):
        if num%i == 0:
            arr.append(i)
            arr_str.append(str(i))

    if sum(arr) == num:
        ans = ' + '.join(arr_str)
        print(f"{num} = {ans}")
    else:
        print(f"{num} is NOT perfect.")
    return


while True:
    n = int(input())
    if n == -1:
        break
    is_perfect(n)