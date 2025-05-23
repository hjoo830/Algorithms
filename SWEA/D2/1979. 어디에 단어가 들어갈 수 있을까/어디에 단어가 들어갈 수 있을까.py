t = int(input())
for tc in range(1, t + 1):
    n, k = map(int, input().split())
    board = []
    answer = 0

    for i in range(n):
        row = list(map(int, input().split()))
        board.append(row)

    spaces = []
    for r in board:
        rCnt = 0
        for c in r:
            if c == 1:
                rCnt += 1
            else:
                if rCnt:
                    spaces.append(rCnt)
                    rCnt = 0
        if rCnt:
            spaces.append(rCnt)

    for c in range(n):
        cCnt = 0
        for r in range(n):
            if board[r][c] == 1:
                cCnt += 1
            else:
                if cCnt:
                    spaces.append(cCnt)
                    cCnt = 0
        if cCnt:
            spaces.append(cCnt)

    for s in spaces:
        if s == k:
            answer += 1

    print(f'#{tc} {answer}')