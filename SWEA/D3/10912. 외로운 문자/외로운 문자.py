T = int(input())
for test_case in range(1, T + 1):
    str = input().strip()
    answer = []
    for s in str:
        if s in answer:
            answer.remove(s)
        else:
            answer.append(s)

    answer.sort()
    if not answer:
        answer = 'Good'
    else:
        answer = ''.join(answer)
    print(f'#{test_case} {answer}')