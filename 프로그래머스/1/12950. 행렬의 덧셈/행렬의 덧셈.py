def solution(arr1, arr2):
    answer = []
    for r in range(len(arr1)):
        sub=[]
        for c in range(len(arr1[0])):
            sub.append(arr1[r][c]+arr2[r][c])            
        answer.append(sub)
    return answer