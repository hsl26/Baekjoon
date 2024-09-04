X = []
Y = []
for _ in range(3):
    x, y = map(int, input().split())
    X.append(x)
    Y.append(y)

X.sort()
Y.sort()

add_x = X[2] if X[0]==X[1] else X[0]
add_y = Y[2] if Y[0]==Y[1] else Y[0]

print(add_x, add_y)