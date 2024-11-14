import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]


def rotate(arr_r, arr_c):  # 회전
    arr_nr = arr_c
    arr_nc = [0] * 4
    for i in range(4):
        arr_nc[i] = -1 * arr_r[i]
    return arr_nr, arr_nc


def flip(arr_r, arr_c):  # 대칭
    arr_nc = [0] * 4
    for i in range(4):
        arr_nc[i] = -1 * arr_c[i]
    return arr_r, arr_nc


def cal(r, c, drs, dcs):  # 테트로미노가 놓인 칸에 쓰여 있는 수들의 합 계산
    res = 0
    for dr, dc in zip(drs, dcs):
        nr, nc = r + dr, c + dc
        if 0 > nr or nr >= N or 0 > nc or nc >= M:
            return -1
        res += board[nr][nc]
    return res


# 테트로미노 좌표
dr_zip = [(0, 0, 0, 0), (0, 0, 1, 1), (0, 1, 2, 2), (0, 1, 1, 2), (0, 0, 0, 1)]
dc_zip = [(0, 1, 2, 3), (0, 1, 0, 1), (0, 0, 0, 1), (0, 0, 1, 1), (0, 1, 2, 1)]

ans = 0
for t in range(5):  # 테트로미노 선택
    drs, dcs = dr_zip[t], dc_zip[t]
    for rot in range(4):
        drs, dcs = rotate(drs, dcs)  # 회전
        for fl in range(2):
            drs, dcs = flip(drs, dcs)  # 대칭

            for r in range(N):
                for c in range(M):
                    ans = max(ans, cal(r, c, drs, dcs))  # 계산 및 값 업데이트

print(ans)