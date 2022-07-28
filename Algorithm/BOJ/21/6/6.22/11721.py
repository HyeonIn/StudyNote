#열 개씩 끊어 출력하기

a = input()
for i in range(len(a)):
  print(a[i],end="")
  if (i+1) % 10 == 0:
    print()