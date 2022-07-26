#최소비용 구하기
#다익스트라 기본 문제
#아니 코드 똑같은데 왜 안되냐 내껀;


import sys
from heapq import heappush, heappop
input = sys.stdin.readline
n = int(input())
m = int(input())
inf = 100000000
s = [[] for i in range(n + 1)]
dp = [inf for i in range(n + 1)]

for i in range(m):
    a, b, w = map(int, input().split())
    s[a].append([b, w])
start, end = map(int, input().split())

def dijkstra(start):
    dp[start] = 0
    heap = []
    heappush(heap, [0, start])
    while heap:
        w, n = heappop(heap)
        if dp[n] < w:
            continue
        for n_n, wei in s[n]:
            n_w = w + wei
            if dp[n_n] > n_w:
                dp[n_n] = n_w
                heappush(heap, [n_w, n_n])
dijkstra(start)
print(dp[end])