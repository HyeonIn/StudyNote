# 소인수분해 by acmicpc
# 20.05.10(MON)

n = int(input())

i = 2

while n != 1:
  if n%i == 0:
    print(i)
    n//=i
  else:
    i += 1