def solution(survey, choices):
    answer = ''
    score = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}
    for i in range(len(survey)):
        disagree = survey[i][0]
        agree = survey[i][1]
        
        if choices[i] == 1:
            score[disagree] += 3
            
        elif choices[i] == 2:
            score[disagree] += 2
            
        elif choices[i] == 3:
            score[disagree] += 1
            
        elif choices[i] == 5:
            score[agree] += 1
            
        elif choices[i] == 6:
            score[agree] += 2
            
        elif choices[i] == 7:
            score[agree] += 3
            
    if score['R'] >= score['T']:
        answer += 'R'
    else:
        answer += 'T'
        
    if score['C'] >= score['F']:
        answer += 'C'
    else:
        answer += 'F'
        
    if score['J'] >= score['M']:
        answer += 'J'
    else:
        answer += 'M'
        
    if score['A'] >= score['N']:
        answer += 'A'
    else:
        answer += 'N'
    
    return answer