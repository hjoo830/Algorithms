def countDivisors(n):
    cnt = 0
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            if i == n / i:
                cnt += 1
            else:
                cnt += 2
    return cnt

def solution(number, limit, power):
    answer = 0
    for i in range(1, number + 1):
        count = countDivisors(i)
        if  count > limit:
            answer += power
        else:
            answer += count
    return answer