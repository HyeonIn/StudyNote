#약수

n = int(input())

arr = list(map(int, input().split()))
arr.sort()

if len(arr) == 1:
  print(arr[0]**2)
else:
  a = arr.pop(0)
  b = arr.pop()
  print(a*b)
