import math

m=int(input())
n=int(input())
sum=0
min=10000

def is_prime(n):
    if n==2:
        return True
    if n<=1 or n%2==0:
        return False
    for i in range(3,int(math.sqrt(n))+2,2):
        if n%i==0:
            return False
    return True

for i in range(m,n+1):
    if is_prime(i):
        sum+=i
        if i<min:
            min=i

if min==10000:
    print("-1")
else:
    print(sum)
    print(min)