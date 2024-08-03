def solution(participant, completion):
    dic={}
    for p in participant:
        dic[p]=0
        
    for p in participant:
        dic[p]+=1
        
    for c in completion:
        dic[c]-=1
        
    for p in participant:
        if (dic[p]!=0):
            return p
