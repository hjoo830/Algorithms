def isClap(num):
    cnt = 0
    for n in str(num):
        if n in '369':
            print('-', end='')
            cnt += 1            
    return cnt > 0

n = int(input())
for i in range(1, n + 1):
    if isClap(i):
        print(end=' ')
    else: 
        print(i, end=' ')