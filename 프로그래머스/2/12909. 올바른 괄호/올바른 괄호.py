def solution(s):
    stack=[]
    if s[0]==')':
        return False
    
    for c in s:
        if (c=='('):
            stack.append(c)
        if (c==')'):
            if(stack):
                stack.pop()
            else:
                return False
    
    return len(stack)==0