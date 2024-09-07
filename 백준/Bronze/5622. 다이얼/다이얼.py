dial = {2: ['A', 'B', 'C'],
        3: ['D', 'E', 'F'],
        4: ['G', 'H', 'I'],
        5: ['J', 'K', 'L'],
        6: ['M', 'N', 'O'],
        7: ['P', 'Q', 'R', 'S'],
        8: ['T', 'U', 'V'],
        9: ['W', 'X', 'Y', 'Z']
        }

string_number = input()

spend_time = 0
for sn in string_number:
    for key in dial:
        if sn in dial[key]:
            time = key + 1
            spend_time += time
            break

print(spend_time)