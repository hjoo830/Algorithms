import itertools

def isPrime(n):
    if n<2: return False
    if n==2: return True
    if n%2==0: return False
    for i in range(3, n//2+1, 2):
        if n%i==0: return False
    return True

def solution(numbers):
    numberList=list(numbers)
    nums=set()
    
    for i in range(1, len(numberList) + 1):
        for perm in itertools.permutations(numberList, i):
            num_str = ''.join(perm).lstrip('0')
            if num_str:  # 빈 문자열을 방지
                nums.add(int(num_str))
    
    primes = [n for n in nums if isPrime(n)]
            
    return len(primes)