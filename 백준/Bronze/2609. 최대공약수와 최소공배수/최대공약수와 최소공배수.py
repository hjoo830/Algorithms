a,b = map(int, input().split())

def gcd(a,b): # 최대공약수
    while(b!=0):
        t=b
        b=a%b
        a=t
    return a

def lcm(a,b): # 최소공배수
    return (a*b) // gcd(a,b)

print(gcd(a,b))
print(lcm(a,b))