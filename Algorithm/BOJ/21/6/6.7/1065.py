

def isHan(a):
  if a < 100:
    return True
  else:
    temp1 = a % 10
    a //= 10
    temp2 = a % 10
    a //= 10
    d = temp1 - temp2

    while a > 0:
      temp3 = a % 10
      a //= 10
      if temp2 - temp3 != d:
        return False
      temp2 = temp3
    return True

n = int(input())

count = 0
for i in range(1,n+1):
  if isHan(i):
    count += 1
print(count)