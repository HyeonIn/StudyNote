#방 번호

a = int(input())

arr = [0 for i in range(10)]

if a == 0:
  arr[0] += 1
while(a>0):

  arr[a%10] += 1
  a//=10

if (arr[6] + arr[9])%2 != 0:
  arr[6] = (arr[6] + arr[9]) // 2 + 1
  arr[9] =arr[6]
else:
  arr[6] = (arr[6]+arr[9])//2
  arr[9] = arr[6]
print(max(arr))