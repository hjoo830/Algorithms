t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    result = ''
    for _ in range(n):
        a, cnt = input().split()
        result += a * int(cnt)
    
    print(f'#{tc}')
    for i in range(0, len(result), 10):
        print(result[i:i + 10])