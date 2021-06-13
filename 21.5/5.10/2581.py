# 소수 by acmicpc
# 20.05.10(MON)

import math

m = int(input())
n = int(input())

def isPrime(a):
  if a == 1:
    return False
  if a == 2:
    return True
  for i in range(2, int(math.sqrt(a))+1):
    if a%i == 0:
      return False
  return True

sumP = 0
minP = 10001
for i in range(m, n+1):
  if isPrime(i):
    sumP += i
    if minP > i:
      minP = i
if minP == 10001:
  minP = -1

if sumP != 0:
  print(sumP)
print(minP)