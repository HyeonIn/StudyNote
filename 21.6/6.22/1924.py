#2007년

m, d = map(int, input().split())

days30 = [4,6,9,11]

day = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]

if m == 1:
  print(day[d%7])
else:
  sumD = 0
  for i in range(1, m):
    if i in days30:
      sumD+=30
    elif i == 2:
      sumD += 28
    else:
      sumD+=31
  sumD += d
  print(day[sumD%7])

