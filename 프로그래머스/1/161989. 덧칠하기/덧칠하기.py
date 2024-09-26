def solution(n, m, section):
    answer = 0
    current = 0
    for s in section:
        if s > current:
            current = s + m - 1
            answer += 1
    return answer