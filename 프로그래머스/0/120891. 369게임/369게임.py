def solution(order):
    answer = 0
    for ch in str(order):
        if ch=='3' or ch=='6' or ch=='9': answer+=1
    return answer