#이항계수 1

n, k = map(int,input().split())

a = 1
b = 1
for i in range(k, 0, -1):
  a *= i
for j in range(k):
  b *= n
  n-=1

print(b//a)