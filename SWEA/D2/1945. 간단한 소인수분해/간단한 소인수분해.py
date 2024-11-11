T = int(input())
nums = [2, 3, 5, 7, 11]
for test_case in range(1, T + 1):
    n = int(input())
    result = [0, 0, 0, 0, 0]
    while (n > 1):
        for i in range(len(nums)):
            if n % nums[i] == 0:
                result[i] += 1
                n //= nums[i]
    print('#', test_case, ' ', sep='', end='')
    print(*result)