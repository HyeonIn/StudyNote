# 분해합 by acmicpc
# 20.05.14(FRI)

n = input()

intN = int(n)
answer = 0
for i in range(intN):
  temp = i
  tempi = i
  for j in range(len(n)):
    temp += tempi%10
    tempi //= 10
  if temp == intN:
    answer = i
    break
print(answer)

