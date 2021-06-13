t = int(input())

for i in range(t):
  n, m = map(int,input().split())
  #nCm을 구하는 문제
  if n == 0:
    print(0)
  else:
    answer = 1
    for j in range(m, m-n, -1):
      answer *= j
    for k in range(1, n+1):
      answer //= k
    print(answer)
