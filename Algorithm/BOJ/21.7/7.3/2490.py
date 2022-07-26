#윷놀이

a = ['E','A','B','C','D']

for i in range(3):
  count0 = 0
  count1 = 0
  arr = list(map(int, input().split()))
  for j in range(4):
    if arr[j] == 0:
      count0+=1
  print(a[count0])
