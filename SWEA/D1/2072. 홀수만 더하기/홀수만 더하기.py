T = int(input())
for test_case in range(1, T + 1):
    nums = list(map(int, (input().split(' '))))
    oddSum = 0
    for num in nums:
    	if num % 2 != 0:
        	oddSum += num
    print('#', test_case, ' ', oddSum, sep='')