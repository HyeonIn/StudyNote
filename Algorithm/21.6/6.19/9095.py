def plus(n):
  a = 1
  b = 2
  c = 4
  if n == 1:
    return(a)
  elif n == 2:
    return(b)
  elif n == 3:
    return(c)
  else:
    answer = 0
    for i in range(4, n+1):
      answer = a+b+c
      a = b
      b = c
      c = answer
    return(answer)


t = int(input())


for i in range(t):

  n = int(input())

  print(plus(n))
