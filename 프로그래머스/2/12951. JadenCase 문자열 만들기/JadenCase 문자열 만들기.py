def solution(s):
    strings = s.lower().split(' ')
    result = []

    for string in strings:
        if string and string[0].isalpha():
            result.append(string[0].upper() + string[1:])
        else:
            result.append(string)
    
    return ' '.join(result)