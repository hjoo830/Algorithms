for tc in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    m = int(input())
    commands = input().split()
    i = 0
    while i < len(commands):
        if commands[i] == 'I':
            x = int(commands[i + 1])
            y = int(commands[i + 2])
            s = list(map(int, commands[i + 3 : i + 3 + y ]))
            
            arr = arr[:x] + s + arr[x:]
            i += 3 + y
        else:
            i += 1
        
    print(f'#{tc} {" ".join(map(str, arr[:10]))}')