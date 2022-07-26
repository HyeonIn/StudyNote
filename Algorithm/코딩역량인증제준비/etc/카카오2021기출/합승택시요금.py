# 레벨 3 문제라 쫄았는데
# 다익스트라 문제 풀다가 해답이 떠올라서 풀어봤다
# 풀리네 이게..?

import heapq

global graph

INF = 1000000


def dijkstra(n, start):
    global graph
    dp = [INF] * (n + 1)
    q = []
    dp[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        f, d = heapq.heappop(q)

        if dp[d] < f:
            continue
        for nf, nd in graph[d]:
            now_f = nf + f
            if now_f < dp[nd]:
                dp[nd] = now_f
                heapq.heappush(q, (now_f, nd))
    return (dp)


def solution(n, s, a, b, fares):
    global graph
    graph = [[] for i in range(n + 1)]

    for c, d, f in fares:
        graph[c].append([f, d])
        graph[d].append([f, c])

    answer = []
    # 합승하여 가는 지점을 k라고 두고 시작점 부터 k 지점까지의 거리의 최소값을 구하고
    # k 지점부터 각자의 집으로 향하는 거리의 최소값을 구한다.
    # 모든 k에 대해 값을 구하여 가장 작은 숫자가 답일 것이다.
    for k in range(1, n + 1):
        stok = dijkstra(n, s)[k]
        ktoa = dijkstra(n, k)[a]
        ktob = dijkstra(n, k)[b]
        answer.append(stok + ktoa + ktob)

    answer = min(answer)

    return answer