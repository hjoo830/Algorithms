T = int(input())
for tc in range(1, T + 1):
    s1 = input().strip()
    s2 = input().strip()
    
    if s1 in s2:
        answer = 1
    else:
        answer = 0
    print(f'#{tc} {answer}')