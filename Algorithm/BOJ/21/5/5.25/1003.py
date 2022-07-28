
t = int(input())

for i in range(t):
  n = int(input())
  
  n0 = 1
  n1 = 0

  m0 = 0
  m1 = 1
  
  for j in range(n-1):
    temp0 = m0
    temp1 = m1

    m0 += n0
    m1 += n1

    n0 = temp0
    n1 = temp1
  
  if n == 0:
    print(n0, n1)
  else:
    print(m0, m1)


