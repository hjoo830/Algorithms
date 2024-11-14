from collections import deque

def bfs(s):
    global maxPath
    q = deque([(s, [s])]) # (노드, 경로)
    
    while q:
        c, path = q.popleft()
        maxPath = max(maxPath, len(path))
        for n in adj[c]:
            if n not in path:
                q.append((n, path + [n]))
    
T = int(input())

for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    adj = [[] for _ in range(n + 1)]
    for i in range(m):
        s, e = map(int, input().split())
        adj[s].append(e)
        adj[e].append(s)

    maxPath = 0
    for i in range(1, n + 1):
        bfs(i)

    print(f'#{test_case} {maxPath}')