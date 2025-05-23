from collections import deque

for tc in range(1, 11):
    n, start = map(int, input().split())
    data = list(map(int, input().split()))
    adj = [[] for _ in range(max(data) + 1)]
    for i in range(0, n, 2):
        s = data[i]
        e = data[i + 1]
        adj[s].append(e)

    for a in adj:
        a.sort()

    v = [False for _ in range(max(data) + 1)]

    def bfs (s):
        q = deque()
        q.append(s)
        v[s] = True
        path = [(0, s)]
        count = 1

        while q:
            for _ in range(len(q)):
                c = q.popleft()

                for n in adj[c]:
                    if not v[n]:
                        q.append(n)
                        v[n] = True
                        path.append((count, n))
            count += 1

        return path
  
    path = bfs(start)
    path.sort(reverse=True,key=lambda x: (x[0], x[1]))
    answer = path[0][1]
    print(f'#{tc} {answer}')