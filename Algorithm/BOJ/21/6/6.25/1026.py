#보물

s = int(input())

arr1 = list(map(int,input().split()))
arr2 = list(map(int,input().split()))

arr1.sort()
arr2.sort()
arr2.reverse()

S = 0

for i in range(s):
  S += arr1[i] * arr2[i]

print(S)