for test_case in range(1, 11):
    t = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    answer = 0
    
    # 행 합
    for r in range(100):
        rowSum = sum(arr[r])
        answer = max(rowSum, answer)
        
    # 열 합
    for c in range(100):
        colSum = 0
        for r in range(100):
            colSum += arr[r][c]
        answer = max(colSum, answer)
        
    # 오른쪽 대각선 합
    rightSum = 0
    for i in range(100):
        rightSum += arr[i][i]
        answer = max(rightSum, answer)
    
    # 왼쪽 대각선 합
    leftSum = 0
    for i in range(99, -1, -1):
        leftSum += arr[i][i]
        answer = max(leftSum, answer)
    
    print(f'#{t} {answer}')