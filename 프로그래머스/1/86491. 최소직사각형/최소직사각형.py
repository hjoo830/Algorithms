def solution(sizes):
    maxW=-1
    maxH=-1
    for s in sizes:
        if s[0] < s[1]:
            s[0],s[1]=s[1],s[0]
        
    for s in sizes:
        if s[0]>maxW:
            maxW=s[0]
        if s[1]>maxH:
            maxH=s[1]
    return maxW*maxH