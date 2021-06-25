n = int(input())

a = 0
b = 1
if n == 0:
  print(a)
elif n == 1:
  print(b)
else:
  for i in range(2, n+1):
    temp = a+b
    a = b
    b = temp
  print(temp)
