def solution(babbling):
    count = 0
    words = ["aya", "ye", "woo", "ma"]
    for i in range(len(babbling)):
        for index, word in enumerate(words):
            if word in babbling[i]:
                babbling[i]=babbling[i].replace(word,str(index))
        if babbling[i].isdigit():
            for j in range(len(babbling[i])-1):
                if babbling[i][j] == babbling[i][j+1]:
                    count-=1
                    break
            count+=1
    return count