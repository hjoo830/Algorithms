from collections import deque

for test_case in range(1, 11):
    T = int(input())
    nums = deque(list(map(int, input().split())))
    while all(num > 0 for num in nums):
        for i in range(1, 6):
            n = nums.popleft()
            n -= i
            if n <= 0:
                nums.append(0)
                break
            else:
            	nums.append(n)
    print('#', T, ' ', end='', sep='')
    print(*nums)