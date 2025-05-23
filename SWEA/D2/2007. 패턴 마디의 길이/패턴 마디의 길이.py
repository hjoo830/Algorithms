t = int(input())
for tc in range(1, t + 1):
    s = input().strip()
    pattern = ''

    for c in s:
        pattern += c
        if pattern == s[len(pattern): len(pattern) * 2]:
            break
        
    print(f'#{tc} {len(pattern)}')