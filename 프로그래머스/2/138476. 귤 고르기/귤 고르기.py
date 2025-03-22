def solution(k, tangerine):
    answer = 0
    tangerineDict = {}
    count = 0
    
    tangerine.sort()
    for t in tangerine:
        if t not in tangerineDict:
            tangerineDict[t] = 1
        else:
            tangerineDict[t] += 1

    tangerineDict = dict(sorted(tangerineDict.items(), key=lambda x: x[1], reverse=True))
    
    for i in tangerineDict:
        count += tangerineDict[i]
        answer += 1
        if count >= k:
            break
    
    return answer