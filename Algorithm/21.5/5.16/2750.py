# 수 정렬하기 by acmicpc
# 20.05.16(SUN))

n = int(input())

nn = []

for i in range(n):
  t = int(input())
  nn.append(t)

nn.sort()

for i in range(n):
  print(nn[i])