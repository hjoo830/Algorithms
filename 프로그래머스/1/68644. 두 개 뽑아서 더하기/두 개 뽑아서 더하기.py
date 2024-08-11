import itertools

def solution(numbers):
    answer = []
    combi = list(map(list,itertools.combinations(numbers, 2)))
    for com in combi:
        answer.append(com[0]+com[1])
    return sorted(list(set(answer)))