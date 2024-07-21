def solution(citations):
    answer = []
    h=0
    cnt=0
    n=len(citations)
    citations.sort()
    for i in citations:
        for j in citations:
            if i<=j: cnt+=1
        answer.append((i,cnt))
        cnt=0
    max=0
    for i,j in answer:
        if (i>=j):
            h=j
        if(h>max): 
            max=h
    return max