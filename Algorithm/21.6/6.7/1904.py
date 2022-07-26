

n = int(input())

if n == 1:
  print(1)
elif n == 2:
  print(2)
else:
  a1 = 1
  a2 = 2
  for i in range(n-2):
    answer = (a1+a2)%15746
    a1 = a2
    a2 = answer
  print(answer)
