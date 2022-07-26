#검증수

number = list(map(int,input().split()))

Pnum = 0
for i in range(5):
  Pnum += number[i]**2

print(Pnum%10)