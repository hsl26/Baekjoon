while True:
    code = input()
    if code == "END":
        break

    code = list(code)
    new_code = code.copy()
    for i in range(len(code)):
        new_code[i] = code[len(code)-i-1]

    new_code = ''.join(new_code)
    print(new_code)