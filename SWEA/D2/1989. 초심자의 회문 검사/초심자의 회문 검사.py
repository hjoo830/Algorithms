t = int(input())
for tc in range(1, t + 1):
    word = input().strip()
    answer = 1

    left = 0
    right = len(word) - 1
    while left <= right:
        if word[left] == word[right]:
            left += 1
            right -= 1
        else:
            answer = 0
            break

    print(f'#{tc} {answer}')