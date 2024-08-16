def solution(s):
    answer = 0
    i = 0
    while i < len(s):
        first = s[i]
        firstCount = 0
        otherCount = 0
        for j in range(i, len(s)):
            if s[j] == first:
                firstCount += 1
            else:
                otherCount += 1
            
            if firstCount == otherCount:
                answer += 1
                i = j + 1  
                break
        else:
            answer += 1
            break 
    
    return answer