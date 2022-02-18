# 문제집
# 힙인가..? 해답보고 지림...
# 문제 재밌는데 조금만 더 생각했으면 맞췄을지도,, ㅠ

import sys
import heapq

input = sys.stdin.readline

n, m = map(int, input().split())

plist = [[] for i in range(n+1)]

indegree = [0 for i in range(n+1)]
# 차수를 리스트로 만들어서 우선순위가 밀리면 차수를 증가시키는 방식

heap = []

result = []

for _ in range(m):
    a, b = map(int, input().split())
    #우선순위가 밀리면 해당 숫자 다음으로 나와야 하므로
    plist[a].append(b)
    #해당 숫자에 연결시키고
    indegree[b] += 1
    #바로 힙에 들어가지 못하도록 차수를 1 증가시킴

for i in range(1, n+1):
    if indegree[i] == 0:
    #차수가 0인 애들부터 최소힙에 넣어줌
        heapq.heappush(heap, i)


while heap: #힙이 비어있지 않으면
    temp = heapq.heappop(heap)
    #현재 힙에서 가장 작은수를 뺌
    result.append(temp)
    #출력 결과에 추가
    for j in plist[temp]:
        #해당 수에 연결된 요소들을 전부 탐색
        indegree[j] -= 1
        #해당 숫자가 먼저빠졌으니 차수를 1씩 낮춰줌
        if indegree[j] == 0:
        #만약 차수가 0이 되었다면, 출력을 해도 되는 상황
            heapq.heappush(heap, j)
            #바로 힙에 넣어줌

for i in result:
    print(i, end=" ")

#진짜 잘짰다 코드; 리스펙