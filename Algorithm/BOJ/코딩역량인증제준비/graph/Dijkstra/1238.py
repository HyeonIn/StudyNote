# 파티
# 다익스트라
# INF 명시때문에 왜 오류가 나는거지;

import sys
import heapq

n, m, x = map(int, sys.stdin.readline().split())

INF = 10000000

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,w = map(int, sys.stdin.readline().split())
    graph[a].append([w,b])

def dijkstra(start):
    dp = [INF] * (n + 1)

    dp[start] = 0
    q = []
    heapq.heappush(q,(0, start))
    while q:
        w, b = heapq.heappop(q)
        if w > dp[b]:
            continue
        for next_w, nb in graph[b]:
            now_w = next_w+w
            if dp[nb] > now_w:
                dp[nb] = now_w
                heapq.heappush(q,(now_w, nb))

    return(dp)


result = 0
for i in range(1, n + 1):
    go = dijkstra(i)
    back = dijkstra(x)
    result = max(result, go[x] + back[i])
print(result)


