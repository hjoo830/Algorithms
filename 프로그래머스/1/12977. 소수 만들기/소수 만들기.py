import itertools, math

def isPrime(n):
    if n == 2: 
        return True
    if n % 2 == 0:
        return False
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n % i == 0:
            return False
    return True

def solution(nums):
    answer = 0
    combi = list(itertools.combinations(nums, 3))
    for c in combi:
        if isPrime(sum(c)): 
            answer += 1
    return answer