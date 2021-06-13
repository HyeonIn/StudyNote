# 블랙잭 by acmicpc
# 20.05.14(FRI)

n , m = map(int, input().split())
data = list(map(int, input().split()))

count = 0
sumN = 0
for i in range(n):
  for j in range(i+1, n):
    for k in range(j+1, n):
      if data[i] + data[j] + data[k] >= sumN and data[i] + data[j] + data[k] <= m:
        sumN = data[i] + data[j] + data[k] 
  
print(sumN)
