t = int(input())

for tc in range(1, t + 1):
    n, k = map(int, input().split())
    scores = []
    for i in range(n):
        mid, fin, hw = map(int, input().split())
        total = (mid * 35 + fin * 45 + hw * 20) / 100
        scores.append([total, i])
    scores.sort(reverse = True)

    grades = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    for i in range(n):
        scores[i][0] = grades[i // (n // 10)]

    for s in scores:
        if s[1] == k-1:
            grade = s[0]
    print(f'#{tc} {grade}')