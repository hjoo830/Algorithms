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
    primes=[]
    
    for i in range(1, len(numberList) + 1):
        for perm in itertools.permutations(numberList, i):
            nums.add(''.join(map(str, perm)))
    nums = list(map(int, nums))
    
    for n in nums:
        if isPrime(n) and n not in primes:
            primes.append(n)
            
    return len(primes)