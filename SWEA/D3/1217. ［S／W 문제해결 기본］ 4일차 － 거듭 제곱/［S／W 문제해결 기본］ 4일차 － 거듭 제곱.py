def power(x, n):
    if n == 0:
        return 1
    return x * power(x, n - 1)

for t in range(1, 11):
    tc = int(input())
    base, exp = map(int, input().split())
    result = power(base, exp)
    print(f'#{tc} {result}')