def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    score = [score[i:i + m] for i in range(0, len(score), m)]
    for box in score:
        if len(box) == m:
            answer += min(box) * len(box)
    return answer