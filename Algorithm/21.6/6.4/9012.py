n = int(input())

for i in range(n):
  s = input()
  stack = []
  answer = True
  for j in range(len(s)):
    if s[j] == ')':
      if len(stack) == 0:
        answer = False
        break
      else:
        stack.pop()
    else:
      stack.append(s[j])
  if len(stack) == 0 and answer == True:
    print('YES')
  else:
    print('NO')