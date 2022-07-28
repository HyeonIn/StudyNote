#트럭
from collections import deque

def solution(bridge_length, weight, truck_weights):
  answer = 0
  
  bridge = deque()
  timeOnBridge = deque()
  trucks = deque(truck_weights)
  
  while bridge or trucks:
    answer += 1

    if bridge:
      if timeOnBridge[0] + bridge_length == answer:
        bridge.popleft()
        timeOnBridge.popleft()
    
    if trucks:
      if sum(bridge) + trucks[0] <= weight:
        bridge.append(trucks.popleft())
        timeOnBridge.append(answer)
  return answer
  
n, w, l = map(int, input().split())
truck_weights = list(map(int, input().split()))

print(solution(w, l, truck_weights))

