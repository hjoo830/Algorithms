T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    grid = []
    for i in range(n):
        row = list(map(int, input().split()))
        grid.append(row)

    maxSum = 0
    for i in range(len(grid)-m+1):
        for j in range(len(grid[i])-m+1):
            sum = 0
            for k in range(m): 
                for l in range(m): 
                    sum += grid[i+k][j+l]        
            if maxSum < sum:
                maxSum = sum
    print(f'#{test_case} {maxSum}')