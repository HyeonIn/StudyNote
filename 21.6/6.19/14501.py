n = int(input())

dp = [0 for i in range(n)]

arr = []

for i in range(n):
  a,b = map(int, input().split())
  arr.append([a,b])

for j in range(n):
  d = j
  while(d <= n-1):
    if d == n-1:
      if arr[d][0] == 1:
        dp[j] += arr[d][1]
        d += arr[d][0]
      else:
        d += arr[d][0]
    else:
      if (d + arr[d][0]) <= n-1:
        dp[j] += arr[d][1]
        d += arr[d][0]
      else:
        d += arr[d][0]
print(dp)

## 보류 6.19