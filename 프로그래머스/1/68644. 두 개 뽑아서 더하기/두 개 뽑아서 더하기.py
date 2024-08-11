import itertools

def solution(numbers):
    answer = []
    combi = list(map(list,itertools.combinations(numbers, 2)))
    for com in combi:
        answer.append(com[0]+com[1])
    answer=list(set(answer))
    answer.sort()
    return answer