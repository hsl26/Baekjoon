C = int(input())

for _ in range(C):
    arr = list(map(int, input().split()))
    N, score = arr[0], arr[1:]
    avg = sum(score)/N
    avg_cnt = len([s for s in score if s > avg])
    print(f"{round(avg_cnt / N * 100, 3)}%")