# 직각삼각형 by acmicpc
# 20.05.11(TUE)

while(True):
  a,b,c, = map(int, input().split())
  if a == 0 and b == 0 and c == 0:
    break
  
  if a > b:
    if a > c:
      if a**2 == b**2+c**2:
        print("right")
        continue
  if b > a:
    if b > c:
      if b**2 == a**2+c**2:
        print("right")
        continue
  if c**2 == b**2+a**2:
    print("right")
    continue

  print("wrong")
  
  




