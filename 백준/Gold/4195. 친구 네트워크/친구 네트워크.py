import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    F = int(input())

    def find(f):
        if f != friends[f]:
            friends[f] = find(friends[f])
        return friends[f]

    friends = {}
    nums = {}

    for _ in range(F):
        F1, F2 = map(str, input().split())

        if F1 not in friends:
            friends[F1] = F1
            nums[F1] = 1
        if F2 not in friends:
            friends[F2] = F2
            nums[F2] = 1

        F1_p = find(F1)
        F2_p = find(F2)
        if F1_p != F2_p:
            friends[F2_p] = F1_p
            nums[F1_p] += nums[F2_p]

        print(nums[F1_p])