#숨바꼭질
#bfs, 그래프이론, 방문한 곳을 다시 방문하지 않게끔 조절했으면 풀렸음..

import sys
from collections import deque
def bfs():
    q  = deque([n])
    while q:
        x = q.popleft()
        if x == k:
            print(dist[x])
            break
        for nx in (x-1, x+1, x * 2):
            if 0 <= nx <= 100000 and dist[nx] == 0:
                dist[nx] = dist[x] + 1
                q.append(nx)

n, k = map(int, sys.stdin.readline().split())

dist = [0] * 100001

bfs()







