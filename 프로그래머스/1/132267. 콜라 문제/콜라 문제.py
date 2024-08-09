def solution(a, b, n):
    answer = 0
    other = 0
    while n>=a:
        other=n-a*(n//a)
        n=(n//a)*b
        answer+=n
        n+=other
    return answer