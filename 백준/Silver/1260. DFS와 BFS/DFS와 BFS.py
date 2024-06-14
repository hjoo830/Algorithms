#1260

def dfs(c):
    v[c]=1
    ans_dfs.append(c)
    for n in adj[c]:
        if v[n]==0: 
            dfs(n) #방문 안한 노드면 재귀함수 호출
            
def bfs(s):
    q=[]
    q.append(s) #큐에 초기 데이터 삽입
    
    v[s]=1
    ans_bfs.append(s)
    
    while q :
        c=q.pop(0) #큐에서 데이터 하나 빼주기
        for n in adj[c]:
            if v[n]==0: #방문 안한 노드라면 큐에 삽입
                q.append(n)
                ans_bfs.append(n)
                v[n]=1


            
N, M, V = map(int, input().split())
adj= [[] for i in range(N+1)]
for i in range(M) :
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)

for i in range(1, N+1):
    adj[i].sort()

v=[0]*(N+1)
ans_dfs=[]
dfs(V)

v=[0]*(N+1)
ans_bfs=[]
bfs(V)

print(*ans_dfs)    #unpacking
print(*ans_bfs)