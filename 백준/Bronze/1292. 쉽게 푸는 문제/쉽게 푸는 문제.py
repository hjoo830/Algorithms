a, b = map(int,input().split())
num=[0]
for i in range(46):
    for j in range(i):
        num.append(i)

print(sum(num[a:b+1]))