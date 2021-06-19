n = int(input())

a = 1
b = 1
if n == 1:
  print(a)
elif n == 2:
  print(b)
else:
  answer = 0
  for i in range(3, n+1):
    answer = a + b
    a = b
    b = answer
  print(answer)
