N, M = map(int, input().split())
site_PW = [tuple(input().split()) for _ in range(N)]
PW_dict = {}
for site, pw in site_PW:
    PW_dict[site] = pw

find_PW = [input() for _ in range(M)]
for site in find_PW:
    print(PW_dict[site])