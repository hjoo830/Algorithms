t = int(input())
for tc in range(1, t + 1):
    m1, d1, m2, d2 = map(int, input().split())
    days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    if m1 == m2:
        answer = d2 - d1
    else:
        answer = days[m1] - d1 + d2
        for i in range(m1 + 1, m2):
            answer += days[i]
    print(f'#{tc} {answer + 1}')