S, K, H = list(map(int, input().split()))

if S+K+H >= 100:
    print("OK")
else:
    min_school = min(S, K, H)
    if min_school == S:
        print("Soongsil")
    elif min_school == K:
        print("Korea")
    else:
        print("Hanyang")