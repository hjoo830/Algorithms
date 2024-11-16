T = int(input())
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    subject = list(map(int, input().split()))
    answer = []
    for i in range(k):
      maxScore = max(subject)
      subject.remove(maxScore)
      answer.append(maxScore)
    print(f'#{test_case} {sum(answer)}')