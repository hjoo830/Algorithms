def solution(players, callings):
    rank = {}
    for i, player in enumerate(players):
        rank[player] = i

    for name in callings:
        current = rank[name]
        prevPlayer = players[current - 1]
        players[current], players[current - 1] = players[current - 1], players[current]
        rank[name] -= 1
        rank[prevPlayer] += 1
    return players