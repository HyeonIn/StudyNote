# 직사각형에서 탈출 by acmicpc
# 20.05.10(MON)

x,y,w,h = map(int, input().split())

xmin = x
ymin = y

if w-x < x:
  xmin = w - x

if h-y < y:
  ymin = h - y

print(xmin if xmin<ymin else ymin)