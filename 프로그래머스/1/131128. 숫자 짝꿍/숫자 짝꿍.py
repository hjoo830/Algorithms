from collections import Counter

def solution(X, Y):
    answer = ''
    countX = Counter(X)
    countY = Counter(Y)
    
    common = countX & countY
            
    if not common:
        return "-1"
    
    char_list = []
    for char, freq in common.items():
        char_list.append(char * freq)
    
    sorted_char_list = sorted(char_list, reverse=True)
    answer = ''.join(sorted_char_list)
            
    if answer == "0" * len(answer):
        return "0"
    
    return answer
