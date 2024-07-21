def solution(array, commends):
    answer=[]
    for n in range(len(commends)):
        i=commends[n][0]
        j=commends[n][1]
        k=commends[n][2]
        new_array=array[i-1:j]
        new_array.sort()
        answer.append(new_array[k-1])
    return answer