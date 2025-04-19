for t in range(1, 11):
    length = int(input())
    str = input()
    
    stack = []
    result = 1
    
    for s in str:
        if not stack:
	        stack.append(s)
        	continue
        if s == ')':
            top = stack.pop()
            if top != '(':
                result = 0
                break
        elif s == ']':
            top = stack.pop()
            if top != '[':
                result = 0
                break
        elif s == '}':
            top = stack.pop()
            if top != '{':
                result = 0
                break
        elif s == '>':
            top = stack.pop()
            if top != '<':
                result = 0
                break
        else:
            stack.append(s)
                
    if stack:
        result = 0
    
    print(f'#{t} {result}')