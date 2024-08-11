a, b = map(int, input().strip().split(' '))

for r in range(b):
    for c in range(a):
        print('*', end='')
    print()