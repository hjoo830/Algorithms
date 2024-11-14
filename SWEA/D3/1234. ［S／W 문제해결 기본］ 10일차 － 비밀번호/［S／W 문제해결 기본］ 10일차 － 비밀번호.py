for test_case in range(1, 11):
    n, str = input().split()
    stack = []
    result = ''
    for s in str:
        if stack and stack[-1] == s:
            stack.pop()
        else:
            stack.append(s)
    result = ''.join(stack)
    print(f'#{test_case} {result}')