n = int(input())

dp = [0 for i in range(n+1)]

arr = []

for i in range(n):
  a,b = map(int, input().split())
  arr.append([a,b])
arr.append([0,0])
for j in range(n+1):
  if arr[j][0]+j <= n:
    for k in range(j+arr[j][0], n+1):
      
      dp[k] = max(dp[j] + arr[j][1], dp[k])
print(max(dp))


## 보류 6.19
## 풀이 성공 6.20