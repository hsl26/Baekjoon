dial = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"]

string_number = input()

spend_time = 0
for sn in string_number:
    for idx, alphas  in enumerate(dial):
        if sn in alphas:
            time = idx + 3
            spend_time += time
            break

print(spend_time)