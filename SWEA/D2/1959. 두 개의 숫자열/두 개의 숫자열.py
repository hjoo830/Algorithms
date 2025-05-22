from collections import deque

t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    answer = 0
    
    if n == m:
        for i in range(n):
            answer += a[i] * b[i]
         
    if n > m: # 항상 a가 짧게
        n, m = m, n
        a, b = b, a
        
    aq = deque(a)
    diff = m - n
    for _ in range(diff):
        aq.append(0)
        	
    sums = []
    for _ in range(diff + 1):
        aqList = list(aq)
        s = 0
        for i in range(m):
            s += aqList[i] * b[i]
        sums.append(s)
        aq.rotate(1)
        
    answer = max(sums)    
    print(f'#{tc} {answer}')