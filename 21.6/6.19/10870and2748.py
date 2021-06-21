n = int(input())

a = 0
b = 1
if n == 0:
  print(a)
elif n == 1:
  print(b)
else:
  answer = 0
  for i in range(2, n+1):
    answer = a + b
    a = b
    b = answer
  print(answer)