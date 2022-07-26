# 체스판 다시 칠하기 by acmicpc
# 20.05.14(FRI)

n , m = map(int,input().split())

data = list(input() for i in range(n))
repair = []
for i in range(n-7):
  for j in range(m-7):
    firstW = 0
    firstB = 0
    for k in range(i, 8+i):
      for l in range(j, 8+j):
        if (k+l)%2 == 0:
          if data[k][l] != "W":
            firstW += 1 
          else:
            firstB += 1
        if (k+l)%2 == 1:
          if data[k][l] != "B":
            firstW += 1
          else:
            firstB += 1
    repair.append(firstB)
    repair.append(firstW)
print(min(repair))

