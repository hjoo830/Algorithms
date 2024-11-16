T = int(input())
for test_case in range(1, T + 1):
    h1, m1, h2, m2 = map(int, input().split())
    if m1 + m2 < 60:
        m = m1 + m2
    else:
        h1 += 1
        m = m1 + m2 - 60
    
    if h1 + h2 < 13:
        h = h1 + h2
    else:
        h = h1 + h2 - 12
    
    print(f'#{test_case} {h} {m}')