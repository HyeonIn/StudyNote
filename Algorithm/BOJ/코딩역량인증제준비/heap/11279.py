#최대힙
#파이썬에는 최소힙을 지원하는 heapq가 있으므로
#이를 활용하여 최대힙을 구현한다. 자연수가 입력되는 문제이므로
#음수로 바꿔서 정렬을 시키면 최대힙이 구성이되고, 튜플로 힙에 집어넣어서
#1번 인덱스로 꺼내온다.

import sys
import heapq

n = int(sys.stdin.readline())

heap = []

for i in range(n):
    x = int(sys.stdin.readline())

    if x == 0:
        try:
            print(heapq.heappop(heap)[1])
        except IndexError:
            print(0)
    else:
        heapq.heappush(heap, (-x,x))
