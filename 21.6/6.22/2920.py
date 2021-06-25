#음계

a = list(map(int, input().split()))

b = [True, True]
for i in range(1,9):
  if a[i-1] != i:
    b[0] = False
for j in range(8,0,-1):
  if a[8-j] != j:
    b[1] = False

if b[0]:
  print("ascending")
elif b[1]:
  print("descending") 
else:
  print("mixed")  