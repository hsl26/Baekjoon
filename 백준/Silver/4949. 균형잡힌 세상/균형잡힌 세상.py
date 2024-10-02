while True:
    sen = input()
    if sen == ".":
        break
    stack = []
    for word in sen:
        if word == '(' or word == '[':
            stack.append(word)
        elif word == ')':
            if len(stack) == 0 or stack[-1] != '(':
                stack.append('0')
                break
            stack.pop()
        elif word == ']':
            if len(stack) == 0 or stack[-1] != '[':
                stack.append('0')
                break
            stack.pop()

    if len(stack) == 0:
        print("yes")
    else:
        print("no")