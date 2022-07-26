# 평범한 배낭 by acmicpc
# 20.05.16(SUN))

N, K = map(int, input().split()) 

item = [[0, 0]] 
for i in range(1, N + 1): 
  item.append(list(map(int, input().split()))) 


dp = [[0] * (K + 1) for _ in range(N + 1)] # (N+1) x (K+1) matrix

for i in range(1, N + 1): 
  for j in range(1, K + 1): 
    if j >= item[i][0]: 
      dp[i][j] = max(dp[i-1][j], dp[i-1][j-item[i][0]] + item[i][1]) 
    else: 
      dp[i][j] = dp[i-1][j] 

print(dp[N][K])

