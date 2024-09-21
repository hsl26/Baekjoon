X, Y = map(list, input().split())
X.reverse()
Y.reverse()

XY = int(''.join(X)) + int(''.join(Y))
ans = list(str(XY))
ans.reverse()

print(int(''.join(ans)))