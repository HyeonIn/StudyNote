import math

t = int(input())

for i in range(t):
  x1,y1,x2,y2 = map(int, input().split())

  n = int(input())

  count = 0
  for j in range(n):
    cx, cy, r = map(int, input().split())

    stoc = math.sqrt((x1-cx)**2 + (y1-cy)**2)
    etoc = math.sqrt((x2-cx)**2 + (y2-cy)**2)
    if stoc < r and etoc > r:
      count += 1
    if stoc > r and etoc < r:
      count += 1
  print(count)    