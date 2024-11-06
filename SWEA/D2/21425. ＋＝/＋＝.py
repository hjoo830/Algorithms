T = int(input())
for test_case in range(1, T + 1):
    a, b, n = map(int, input().split())
    count = 0
    while a <= n and b <= n:
        if a > b:
            a = a
            b += a
            count += 1
        else:
            a += b
            b = b
            count += 1    
    print(count)