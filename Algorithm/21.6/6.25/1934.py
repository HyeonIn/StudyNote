# 최소공배수

t = int(input())
for i in range(t):
  a , b = map(int, input().split())

  if b > a:
    a1 = b
    b1 = a
  else:
    a1 = a
    b1 = b

  while(a1%b1 != 0):
    temp = a1%b1
    a1 = b1
    b1 = temp

  print(a*b//b1)