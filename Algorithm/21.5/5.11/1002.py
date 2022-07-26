# 터렛 by acmicpc
# 20.05.11(TUE)

import math 

t = int(input())

for i in range(t):
  x1, y1, r1, x2, y2, r2 = map(int, input().split())

  if x1 == x2 and y1 == y2:
    if r1 != r2:
      print(0)
    else:
      print(-1)
  else:
    if (x2-x1)**2 + (y2-y1)**2 == (r1 + r2)**2:
      print(1)
    elif math.sqrt((x2-x1)**2 + (y2-y1)**2) + r1 == r2:
      print(1)
    elif math.sqrt((x2-x1)**2 + (y2-y1)**2) + r2 == r1:
      print(1)
    
    elif math.sqrt((x2-x1)**2 + (y2-y1)**2) > r1 + r2:
      print(0)
    elif math.sqrt((x2-x1)**2 + (y2-y1)**2) + r1 < r2:
      print(0)
    elif math.sqrt((x2-x1)**2 + (y2-y1)**2) + r2 < r1:
      print(0)
    else:
      print(2)
