#연결요소의 개수
#그래프, bfs

import sys
from collections import deque

def bfs(n):
    global count
    q = deque([n])

    if check[n] == 0:
        check[n] = count
        count += 1

    while q:
        x = q.popleft()
        for i in graph[x]:
            if check[i] == 0 :
                check[i] = check[x]
                q.append(i)
n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]
check = [0] * (n+1)
global count
count = 1

for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)


for i in range(1, n+1):
    bfs(i)
print(max(check))