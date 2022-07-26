# 네번째점 by acmicpc
# 20.05.10(MON)

x1, y1 = map(int, input().split())

x2, y2 = map(int, input().split())

x3, y3 = map(int, input().split())

if x1 == x2:
  x4 = x3
if x1 == x3:
  x4 = x2
if x2 == x3:
  x4 = x1

if y1 == y2:
  y4 = y3
if y1 == y3:
  y4 = y2
if y2 == y3:
  y4 = y1

print (x4, y4)



