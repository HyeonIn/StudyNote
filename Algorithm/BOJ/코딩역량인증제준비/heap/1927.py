#최소 힙

import sys
import heapq #우선순위 큐 내장 모듈


n = int(sys.stdin.readline())

heap = []

for i in range(n):
    x = int(sys.stdin.readline())

    if x == 0:
        try:
            print(heapq.heappop(heap))
        except IndexError:
            print(0)
    else:
        heapq.heappush(heap,x)
