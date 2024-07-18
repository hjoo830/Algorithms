def solution(n, lost, reserve):
    answer = 0 
    other=[]
    
    choice=[]
    
    lost.sort()
    reserve.sort()
    
    for i in range(1,n+1):
        if(i in lost and i in reserve):
            other.append(i)
            lost.remove(i)
            reserve.remove(i)
        elif(i not in lost and i not in reserve):
            other.append(i)

    print("other",other)
    print("lost",lost)
    print("reserve",reserve)
    
    can=[[0 for j in range(2)] for i in range(len(reserve))]
    for i in range(len(reserve)):
        can[i][0]=reserve[i]-1
        can[i][1]=reserve[i]+1
    print("can",can)
    
    for i in range(len(reserve)-1):
        if (can[i][0] not in choice and can[i][0]>0 and can[i][0] not in other and can[i][0] not in reserve):
            choice.append(can[i][0])
        if (can[i][1]==can[i+1][0]):
            if (can[i][1] not in choice and can[i][1]>0 and can[i][1] not in other and can[i][1] not in reserve):
                choice.append(can[i][1])
        if (can[i+1][1] not in choice and can[i+1][1]<=n and can[i+1][1] not in other and can[i+1][1] not in reserve):
            choice.append(can[i+1][1])
            
    if (len(reserve)==1):
        if (reserve[0]-1>0 and reserve[0]-1 in lost):
            choice.append(reserve[0]-1)
        elif (reserve[0]+1<=n and reserve[0]+1 in lost):
            choice.append(reserve[0]+1)
            
    print("choice",choice)
    answer=len(choice)+len(other)+len(reserve)
    
    return answer