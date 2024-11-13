for test_case in range(1, 11):
    n = int(input())
    height = list(map(int, input().split()))
    for i in range(n):
        maxIndex = height.index(max(height))
        minIndex = height.index(min(height))
        height[maxIndex] -= 1
        height[minIndex] += 1
    print(f'#{test_case} {max(height) - min(height)}')