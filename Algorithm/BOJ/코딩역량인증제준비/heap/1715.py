# 카드 정렬하기
# 최소힙 활용해서 더하기? 정답
# 계속 작은수끼리 더하려면 최소힙을 활용해야됨.

import sys
import heapq

input = sys.stdin.readline
n = int(input())

heap = []

if n == 1:
    print(0)
    exit(0)
for i in range(n):
    x = int(input())
    heapq.heappush(heap, x)

answer = 0
while True:
    a = heapq.heappop(heap)
    b = heapq.heappop(heap)
    answer += a+b
    if len(heap) == 0:
        break
    heapq.heappush(heap, a+b)

print(answer)
