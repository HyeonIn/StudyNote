n = int(input())

a = 1

if n == 1:
  print(a)
else:
  answer = 0
  for i in range(2,n+1):
    if i % 2 == 0:
      answer = a*2+1
      a = answer
    else:
      answer = a*2-1
      a = answer
  print(answer%10007)
