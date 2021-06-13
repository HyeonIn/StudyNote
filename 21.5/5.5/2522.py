# 별찍기-12 by acmicpc
# 20.05.05(WED)
n = int(input())

for i in range(n):
  for j in range(n-i-1):
    print(" ", end="")
  for p in range(i+1):  
    print("*", end="")
  print()
for i in range(n-1):
  for j in range(i+1):
    print(" ", end="")
  for p in range(n-i-1):  
    print("*", end="")
  print()