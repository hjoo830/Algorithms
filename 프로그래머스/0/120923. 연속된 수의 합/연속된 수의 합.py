def solution(num, total):
    answer = []
    count=0
    center=total//num
    answer.append(center)
    while len(answer)<num:
        count+=1
        answer.append(center+count)
        if len(answer)==num: break
        else: answer.append(center-count)        
    return sorted(answer)