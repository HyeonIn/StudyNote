n = int(input())

arr = list(map(int,input().split()))

dp1 = [0 for i in range(n)]
dp2 = [0 for i in range(n)]
dp3 = [0 for i in range(n)]

for i in range(n):
  for j in range(i):
    if arr[j] < arr[i] and dp1[j] > dp1[i]:
      dp1[i] = dp1[j]
  dp1[i] += 1

for i in range(n-1, -1, -1):
  for j in range(n-1, i, -1):
    if arr[j] < arr[i] and dp2[j] > dp2[i]:
      dp2[i] = dp2[j]
  dp2[i] += 1

dp3 = []
for i in range(n):
  dp3.append(dp1[i] + dp2[i] -1)


print(max(dp3))