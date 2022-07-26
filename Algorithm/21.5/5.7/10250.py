# acm 호텔 by acmicpc
# 20.05.07(FRI)

t = int(input())
for i in range(t):
  h, w, n = map(int, input().split())
  x = n%h
  y = n//h+1

  if x == 0:
    x = h
  if n%h == 0:
    y -=1
  
  print(x*100+y)