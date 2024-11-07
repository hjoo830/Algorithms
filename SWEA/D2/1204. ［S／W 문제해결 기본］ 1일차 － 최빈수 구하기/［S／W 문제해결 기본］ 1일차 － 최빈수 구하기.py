T = int(input())
for test_case in range(1, T + 1):
    testNum = int(input())
    nums = list(map(int, input().split()))
    nums.sort()
    dict = {}
    for n in nums:
        if n not in dict:
            dict[n] = 1
        else:
            dict[n] += 1
    modes = []
    for k, v in dict.items():
        if max(dict.values()) == v:
            modes.append(k)
    print('#', testNum, ' ', max(modes), sep='')