def gcd(a,b):
    if a%b: return gcd(b,a%b)
    return b

def lcm(a,b):
    return a*b // gcd(a,b)

def solution(arr):
    while len(arr) >= 2:
        a = arr.pop()
        b = arr.pop()
        arr.append(lcm(a,b))
    return arr.pop()