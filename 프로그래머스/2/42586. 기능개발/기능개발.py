def solution(progresses, speeds):
    answer = []
    period=[]
    for i in range(len(progresses)):
        day=1
        while (progresses[i]+speeds[i]<100):
            day+=1
            progresses[i]+=speeds[i]
        period.append(day)
    
    i=0
    k=1
    while i<len(period):
        cnt=1
        while (i+k<len(period) and period[i]>=period[i+k]):
            cnt+=1
            k+=1
        answer.append(cnt)
        i+=k
        k=1
    return answer