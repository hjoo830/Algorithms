import sys

def isPrime(n):
  if n == 1:
    return False
  
  if n == 2:
    return True
  
  if n % 2 == 0:
    return False
  
  for i in range(3, int(n ** 0.5) + 1, 2):
    if n % i == 0:
      return False
    
  return True

input = sys.stdin.readline
n, m = map(int, input().split())
for num in range(n, m + 1):
  if isPrime(num):
    print(num)