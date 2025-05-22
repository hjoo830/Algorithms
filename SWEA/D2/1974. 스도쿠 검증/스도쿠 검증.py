t = int(input())
for tc in range(1, t + 1):
    arr = []
    for i in range(9):
        row = list(map(int, input().split()))
        arr.append(row)
    
    answer = 1
    for r in range(9):
        cSet = set()
        for c in range(9):
            cSet.add(arr[r][c])
        if len(cSet) != 9:
            answer = 0
            break
            
    for c in range(9):
        rSet = set()
        for r in range(9):
            rSet.add(arr[r][c])
        if len(rSet) != 9:
            answer = 0
            break
        
    for r in range(0, 9, 3):
        for c in range(0, 9, 3):
            set3 = set()
            for i in range(3):
                for j in range(3):
                    set3.add(arr[r + i][c + j])
            if len(set3) != 9:
                answer = 0
                break
    
    print(f'#{tc} {answer}')