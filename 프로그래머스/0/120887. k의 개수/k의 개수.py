def solution(i, j, k):
    answer = 0
    numList=[]
    for n in range(i,j+1):
        numList.append(n)
    for ch in str(numList):
        if ch==str(k): answer+=1
    return answer