#알파벳 개수

s = input()

arr = [0 for i in range(26)]

for i in range(len(s)):
  arr[ord(s[i])-97] += 1

for j in range(26):
  print(arr[j], end=" ")