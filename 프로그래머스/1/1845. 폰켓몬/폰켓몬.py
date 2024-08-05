def solution(nums):
    N=len(nums)//2
    dic={}
    for num in nums:
        dic[num]=0
    for num in nums:
        dic[num]+=1
    
    return min(len(dic), N)