from collections import deque

for _ in range(1, 11):
    tc, n = map(int, input().split())
    data = list(map(int, input().split()))
    adj = [[] for _ in range(100)]
    for i in range(0, len(data), 2):
        s = data[i]
        e = data[i + 1]
        adj[s].append(e)

    v = [False] * 100

    def bfs (s):
        q = deque()
        q.append(s)
        v[s] = True

        while q:
            c = q.popleft()

            for n in adj[c]:
                if n == 99:
                    return 1
                if not v[n]:
                    q.append(n)
                    v[n] = True
        return 0
  
    answer = bfs(0)
    print(f'#{tc} {answer}')