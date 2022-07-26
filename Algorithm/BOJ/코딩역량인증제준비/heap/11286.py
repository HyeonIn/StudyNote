# 절대값 힙
# 음수를 양수로 바꿔서 튜플로 만들면 될듯? 정답
# 튜플로 넣으면 앞이 똑같으면 뒤에 요소로 정렬 되기 때문에
# (1,-1) (1,1) 순서로 정렬될 것이라 예상, 정답

import sys
import heapq

n = int(sys.stdin.readline())

heap = []

for i in range(n):
    x = int(sys.stdin.readline())

    if x < 0 :
        heapq.heappush(heap, (-x, x))
    elif x > 0:
        heapq.heappush(heap, (x,x))
    else:
        try:
            print(heapq.heappop(heap)[1])
        except:
            print(0)