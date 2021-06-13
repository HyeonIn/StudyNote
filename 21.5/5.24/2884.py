h, m = map(int, input().split())


ch, cm = 0, 0
if m < 45:
  cm = 60 + m - 45
  if h == 0:
    ch = 23
  else:
    ch = h - 1
else:
  ch = h
  cm = m - 45
print(ch, cm)