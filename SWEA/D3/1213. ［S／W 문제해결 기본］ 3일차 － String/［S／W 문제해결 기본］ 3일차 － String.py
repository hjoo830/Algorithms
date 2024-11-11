for _ in range(10):
    testNum = int(input())
    target = input()
    text = input()
    list = text.split(target)
    answer = len(list) - 1
    print('#', testNum, ' ', answer, sep='')