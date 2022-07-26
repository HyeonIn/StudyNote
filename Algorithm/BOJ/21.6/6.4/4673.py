check = [[i, 0] for i in range(0,10001)]

n = 1

while(True):
  temp = n
  tempN = n
  while temp > 0:
    tempN += temp%10
    temp //= 10 
  if tempN >= 10000:
    break
  check[tempN][1] = 1
  n += 1


for k in range(1, 9994):
  if check[k][1] == 0:
    print(check[k][0])