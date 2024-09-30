def solution(s, skip, index):
    answer = ''
    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    
    for ch in skip:
        if ch in alphabet:
            alphabet.remove(ch)
            
    for ch in s:
        idx = (alphabet.index(ch) + index) % len(alphabet)
        answer += alphabet[idx]
    return answer