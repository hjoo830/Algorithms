def solution(hp):
    answer = 0
    while hp>=5:
        answer+=(hp//5)
        hp%=5
    if hp>=3: 
        answer+=1
        hp-=3
    if hp>0:
        answer+=hp
        hp-=1
    return answer