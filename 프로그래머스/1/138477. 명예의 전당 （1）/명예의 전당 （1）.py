def solution(k, score):
    answer = []
    rank = []
    for s in score:
        if len(rank) < k:
            rank.append(s)
            rank.sort(reverse = True)
            answer.append(min(rank))
            continue

        if s > rank[k - 1]:
            rank.append(s)
            rank.sort(reverse = True)
            del rank[k:]
        answer.append(min(rank))
    return answer