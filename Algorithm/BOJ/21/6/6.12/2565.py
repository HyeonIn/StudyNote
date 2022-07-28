n = int(input())

arr = [list(map(int, input().split())) for i in range(n)]

dp = [0 for i in range(n)]

arr.sort()

for i in range(n):
  for j in range(i):
    if arr[j][1] < arr[i][1] and dp[j] > dp[i]:
      dp[i] = dp[j]
  dp[i] += 1

print(n-max(dp))
