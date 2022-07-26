#지능형 기차

MAX = 0
P = 0
for i in range(4):
  a, b = map(int,input().split())
  P -= a
  P += b
  if P > MAX:
    MAX = P
print(MAX)