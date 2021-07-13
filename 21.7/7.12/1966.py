#프린터 큐
def solution(priorities, location):
  outCount = 0
  while(True):
    if priorities[0] >= max(priorities):
      if location == 0:
        outCount+=1
        break
      else:
        outCount += 1
        priorities.pop(0)
        location -= 1
    else:
      if location == 0:
        priorities.append(priorities[0])
        priorities.pop(0)
        location = len(priorities)-1
      else:
        priorities.append(priorities[0])
        priorities.pop(0)
        location -= 1
  return outCount
TC = int(input())
for i in range(TC):
  n, m = map(int, input().split())
  priorities = list(map(int, input().split()))
  print(solution(priorities, m))
  