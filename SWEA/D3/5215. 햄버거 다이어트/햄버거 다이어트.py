T = int(input())
for test_case in range(1, T + 1):
    n, l = map(int, input().split())
    ingredient = []
    for i in range(n):
        t, k = map(int, input().split())
        ingredient.append((t, k))
    
    dp = [0] * (l + 1)
    for t, k in ingredient:
        for i in range(l, k - 1, -1):
            dp[i] = max(dp[i], dp[i - k] + t)
    print(f'#{test_case} {max(dp)}')