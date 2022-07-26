# 영화감독 숌 by acmicpc
# 20.05.14(FRI)

n = int(input())

temp = 666
count = 0
while True:
  if '666' in str(temp):
    count += 1
  if count ==  n:
    print(temp)
    break 
  temp += 1

