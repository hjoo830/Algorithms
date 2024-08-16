def solution(A, B):
    answer = 0
    temp=A
    if A==B: return answer
    while(temp!=B):
        answer+=1
        if answer>=len(A):
            return -1
        temp=''
        temp+=A[-answer:]
        temp+=A[:len(A)-answer]
    return answer