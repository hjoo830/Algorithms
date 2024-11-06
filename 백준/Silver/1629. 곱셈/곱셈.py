import sys

input = sys.stdin.readline
a, b, c = map(int, input().split())

def calculMod(a, b, c):
    if b == 0:
        return 1
    elif b == 1:
        return a % c

    half = calculMod(a, b // 2, c)
    half = (half * half) % c

    if b % 2 == 0:
        return half
    else:
        return (half * a) % c 
    
print(calculMod(a, b, c))
