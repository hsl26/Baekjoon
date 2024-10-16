N, M = map(int, input().split())
tree = list(map(int, input().split()))
tree += [0]

if N == 1:
    print(tree[0] - M)
else:
    tree.sort(reverse=True)

    m = 0
    past_h = 0
    ts, te = 0, 0
    for idx, h in enumerate(tree):
        m += idx*(past_h-h)
        past_h = h
        if m >= M:
            ts, te = idx-1, idx
            break

    max_h, min_h = tree[ts], tree[te]
    ans = min_h

    ans += (m-M)//te

    print(ans)