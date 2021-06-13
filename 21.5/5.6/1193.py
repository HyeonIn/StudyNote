# 분수찾기 by acmicpc
# 21.05.06(THU)


x = int(input())
cx = x
it = 0

while(x>0):
  x-=it
  if x<=0:
    break
  it+=1

n = it+x
c=it
m=1
for ii in range(n-1):
    c -= 1
    m += 1

if it%2 == 1:
  print("%d/%d" %(c,m))
else:
  print("%d/%d" %(m,c))


