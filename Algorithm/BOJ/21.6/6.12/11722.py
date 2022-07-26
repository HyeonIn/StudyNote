n = int(input())

arr = list(map(int,input().split()))

dp = [0 for i in range(n)]

for i in range(n-1, -1, -1):
  for j in range(n-1, i, -1):
    print(i, j)
    if arr[j] < arr[i] and dp[j] > dp[i]:
      dp[i] = dp[j]
  dp[i] += 1

print(max(dp))

