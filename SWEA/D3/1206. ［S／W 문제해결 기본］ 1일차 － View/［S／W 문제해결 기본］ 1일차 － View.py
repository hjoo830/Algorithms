for test_case in range(1, 11):
    n = int(input())
    building = list(map(int, input().split()))
    leftOk = []
    rightOk = []
    result = {}
    
    for i in range(2, n - 1):
        if  (building[i] - building[i - 1]) > 0 and (building[i] - building[i - 2]) > 0:
            leftOk.append((i, min((building[i] - building[i - 1]), (building[i] - building[i - 2]))))
        if  (building[i] - building[i + 1]) > 0 and (building[i] - building[i + 2]) > 0:
            rightOk.append((i, min((building[i] - building[i + 1]), (building[i] - building[i + 2]))))
    
    for l in leftOk:
        for r in rightOk:
            if l[0] == r[0] and l[0] not in result:
                result[l[0]] = min(l[1], r[1])
                
    answer = sum(list(result.values()))
    print(f'#{test_case} {answer}')
