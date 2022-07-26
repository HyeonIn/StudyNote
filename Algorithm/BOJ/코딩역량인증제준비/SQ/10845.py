# 큐

import sys

n = int(sys.stdin.readline())
q = []

for i in range(n):

    cmd = sys.stdin.readline().split()
    CMD = cmd[0]
    if CMD == "push":
        q.append(cmd[1])
    elif CMD == "back":
        if not q:
            print(-1)
        else:
            print(q[len(q)-1])
    elif CMD == "size" :
        print(len(q))
    elif CMD == "pop" :
        if not q:
            print(-1)
        else:
            print(q.pop(0))
    elif CMD == "empty":
        print(1 if not q else 0)
    elif CMD == "front":
        if not q:
            print(-1)
        else:
            print(q[0])