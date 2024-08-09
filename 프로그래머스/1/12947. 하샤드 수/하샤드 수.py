def solution(x):
    sum=0
    nums=list(map(int,str(x)))
    for n in nums:
        sum+=n
    if x%sum==0: return True
    else: return False
