def gcd(a,b):
    if a%b: return gcd(b,a%b)
    return b

def lcm(a,b):
    return a*b // gcd(a,b)

def solution(n, m):
    return [gcd(n,m), lcm(n,m)]