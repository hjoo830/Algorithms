T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    result = []
    for m in money:
        result.append(n // m)
        n %= m

    print(f'#{test_case}')
    print(*result)