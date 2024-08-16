while True:
    boy, girl = list(map(int, input().split()))
    if boy==0 and girl==0:
        break
    print(boy+girl)