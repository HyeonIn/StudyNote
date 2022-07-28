#제로

k = int(input())


sumK = []

for i in range(k):
  tempK = int(input())
  if tempK == 0:
    sumK.pop()
  else:
    sumK.append(tempK)
print(sum(sumK))