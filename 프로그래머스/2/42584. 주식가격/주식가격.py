def solution(prices):
    answer = []
    for i in range(len(prices)-1):
        down=False
        for j in range(i+1, len(prices)):
            if (prices[i]>prices[j]):
                answer.append(j-i)
                down=True
                break
        if not down:
            answer.append(j-i)
    answer.append(0)
    return answer