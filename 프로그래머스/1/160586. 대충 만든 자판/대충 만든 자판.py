def solution(keymap, targets):
    answer = []
    for target in targets:
        total = 0
        for ch in target:
            flag = False
            count = 100
            for key in keymap:
                if ch in key:
                    count = min(key.index(ch) + 1, count)
                    flag = True
            if not flag:
                total = -1
                break
            total += count
        answer.append(total)
    return answer