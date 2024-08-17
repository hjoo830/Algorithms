def solution(lottos, win_nums):
    answer = []
    count=0
    for n in lottos:
        if n in win_nums:
            count+=1
            
    if count==0: count+=1
    answer.append(7-count) # 최저 순위

    for n in lottos:
        if n==0: count+=1
        
    if count==7: count-=1
    answer.append(7-count) # 최고 순위
    
    return sorted(answer)